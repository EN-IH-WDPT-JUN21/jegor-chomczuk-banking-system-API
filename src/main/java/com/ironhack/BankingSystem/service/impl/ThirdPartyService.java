package com.ironhack.BankingSystem.service.impl;

import com.ironhack.BankingSystem.controller.dto.ThirdPartyTransactionDTO;
import com.ironhack.BankingSystem.dao.Account;
import com.ironhack.BankingSystem.dao.Checking;
import com.ironhack.BankingSystem.dao.CreditCard;
import com.ironhack.BankingSystem.dao.Savings;
import com.ironhack.BankingSystem.interfaces.Freezable;
import com.ironhack.BankingSystem.interfaces.Penalizable;
import com.ironhack.BankingSystem.dao.ThirdPartyTransaction;
import com.ironhack.BankingSystem.dao.ThirdParty;
import com.ironhack.BankingSystem.repository.AccountRepository;
import com.ironhack.BankingSystem.repository.ThirdPartyTransactionRepository;
import com.ironhack.BankingSystem.repository.ThirdPartyRepository;
import com.ironhack.BankingSystem.service.interfaces.IThirdPartyService;
import com.ironhack.BankingSystem.utils.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Currency;
import java.util.List;

@Service
public class ThirdPartyService implements IThirdPartyService {

    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionService transactionService;

    @Autowired
    ThirdPartyTransactionRepository thirdPartyTransactionRepository;


    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public ThirdParty createThirdParty(ThirdParty thirdParty) {

        thirdParty.setHashedKey(passwordEncoder.encode(thirdParty.getHashedKey()));
        return thirdPartyRepository.save(thirdParty);
    }

    public List<ThirdParty> getAllThirdPartyAccounts() {
        return thirdPartyRepository.findAll();
    }

    public void sendMoney(ThirdPartyTransactionDTO thirdPartyTransactionDTO) {

        Account account = evaluateAccounts(thirdPartyTransactionDTO);
        account.setBalance(new Money(account.getBalance().getAmount().add(thirdPartyTransactionDTO.getAmount().getAmount()), account.getBalance().getCurrency()));
        if (account instanceof Checking) transactionService.applyMonthlyFee((Checking) account);
        if (account instanceof CreditCard) transactionService.applyInterestRate((CreditCard) account);
        if (account instanceof Savings) transactionService.applyInterestRate((Savings) account);
        accountRepository.save(account);
        thirdPartyTransactionRepository.save(new ThirdPartyTransaction(
                account,
                thirdPartyRepository.findById(thirdPartyTransactionDTO.getThirdPartyId()).get(),
                new Money(thirdPartyTransactionDTO.getAmount().getAmount(), thirdPartyTransactionDTO.getCurrency() == null ? Currency.getInstance("USD") : thirdPartyTransactionDTO.getCurrency())
        ));
    }

    public void receiveMoney(ThirdPartyTransactionDTO thirdPartyTransactionDTO) {
        Account account = evaluateAccounts(thirdPartyTransactionDTO);

        if (transactionService.enoughFunds(account, thirdPartyTransactionDTO.getAmount().getAmount())) {
            if (account instanceof Freezable) {
                transactionService.checkStatus((Freezable) account);
                transactionService.checkFraud((Freezable) account);
            }
            if (account instanceof Penalizable) {
                transactionService.checkBalanceAndApplyExtraFeesThirdParty((Penalizable) account, thirdPartyTransactionDTO.getAmount().getAmount());
            }

            if (account instanceof Checking) transactionService.applyMonthlyFee((Checking) account);
            if (account instanceof CreditCard) transactionService.applyInterestRate((CreditCard) account);
            if (account instanceof Savings) transactionService.applyInterestRate((Savings) account);

            account.setBalance(new Money(account.getBalance().getAmount().subtract(thirdPartyTransactionDTO.getAmount().getAmount()), account.getBalance().getCurrency()));
            accountRepository.save(account);
            thirdPartyTransactionRepository.save(new ThirdPartyTransaction(
                    account,
                    thirdPartyRepository.findById(thirdPartyTransactionDTO.getThirdPartyId()).get(),
                    new Money(thirdPartyTransactionDTO.getAmount().getAmount().negate(), thirdPartyTransactionDTO.getCurrency() == null ? Currency.getInstance("USD") : thirdPartyTransactionDTO.getCurrency())
            ));
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Not enough funds");
        }

    }

    private Account evaluateAccounts(ThirdPartyTransactionDTO thirdPartyTransactionDTO) {
        if (accountRepository.findById(thirdPartyTransactionDTO.getAccountId()).isPresent() && thirdPartyRepository.findById(thirdPartyTransactionDTO.getThirdPartyId()).isPresent()) {
            Account account = accountRepository.findById(thirdPartyTransactionDTO.getAccountId()).get();
            ThirdParty thirdParty = thirdPartyRepository.findById(thirdPartyTransactionDTO.getThirdPartyId()).get();
            if (account.getSecretKey().equals(thirdPartyTransactionDTO.getSecretKey()) && thirdParty.getHashedKey().equals(thirdPartyTransactionDTO.getHashedKey())) {
                return account;
            } else if (!account.getSecretKey().equals(thirdPartyTransactionDTO.getSecretKey())) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Wrong Secret Key");
            } else {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Wrong Hashed key");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, but we couldn't find the account or the third party to make this transaction");
        }
    }
}
