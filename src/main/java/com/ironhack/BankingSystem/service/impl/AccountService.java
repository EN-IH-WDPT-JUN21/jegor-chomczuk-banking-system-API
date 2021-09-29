package com.ironhack.BankingSystem.service.impl;

import com.ironhack.BankingSystem.controller.dto.AccountHolderInformationDTO;
import com.ironhack.BankingSystem.controller.dto.AccountInfoDTO;
import com.ironhack.BankingSystem.dao.Account;
import com.ironhack.BankingSystem.dao.CreditCard;
import com.ironhack.BankingSystem.dao.Savings;
import com.ironhack.BankingSystem.repository.AccountHolderRepository;
import com.ironhack.BankingSystem.repository.AccountRepository;
import com.ironhack.BankingSystem.service.interfaces.IAccountService;
import com.ironhack.BankingSystem.utils.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    TransactionService transactionService;

    public AccountInfoDTO getAccountById(Long id) {
        if (accountRepository.findById(id).isPresent()) {
            return convertAccountIntoDTO(accountRepository.findById(id).get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account with id " + id + " doesn't exist in the database");
        }
    }

    public Money getBalanceById(Long id) {

        if (accountRepository.findById(id).isPresent()) {
            return accountRepository.findById(id).get().getBalance();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account with id " + id + " doesn't exist in the database");
        }
    }

    public void updateBalance(Long accountId, Money money) {

        if (accountRepository.findById(accountId).isPresent()) {

            Account account = accountRepository.findById(accountId).get();
            account.setBalance(money);
            accountRepository.save(account);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account with id " + accountId + " doesn't exist in the database");
        }
    }

    public Money getBalance(Long accountId, UserDetails userDetails) {

        if (accountRepository.findById(accountId).isPresent()) {
            Account account = accountRepository.findById(accountId).get();
            if (account.getAccountHolder().getUsername().equals(userDetails.getUsername()) || account.getSecondaryAccountHolder().getUsername().equals(userDetails.getUsername())) {
                if (account instanceof CreditCard) transactionService.applyInterestRate((CreditCard) account);
                if (account instanceof Savings) transactionService.applyInterestRate((Savings) account);
                return account.getBalance();
            } else {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You don't have permissions for this account");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account with id " + accountId + " doesn't exist in the database");
        }
    }

    private AccountInfoDTO convertAccountIntoDTO(Account account) {

        if (account.getSecondaryAccountHolder() == null) {
            return new AccountInfoDTO(
                    account.getAccountId(),
                    account.getBalance(),
                    new AccountHolderInformationDTO(
                            account.getAccountHolder().getUsername(),
                            account.getAccountHolder().getName(),
                            account.getAccountHolder().getDateOfBirth(),
                            account.getAccountHolder().getPrimaryAddress(),
                            account.getAccountHolder().getMailingAddress()),
                    null,
                    account.getCreationDate()
            );

        } else {
            return new AccountInfoDTO(
                    account.getAccountId(),
                    account.getBalance(),
                    new AccountHolderInformationDTO(
                            account.getAccountHolder().getUsername(),
                            account.getAccountHolder().getName(),
                            account.getAccountHolder().getDateOfBirth(),
                            account.getAccountHolder().getPrimaryAddress(),
                            account.getAccountHolder().getMailingAddress()),

                    new AccountHolderInformationDTO(
                            account.getSecondaryAccountHolder().getUsername(),
                            account.getSecondaryAccountHolder().getName(),
                            account.getSecondaryAccountHolder().getDateOfBirth(),
                            account.getSecondaryAccountHolder().getPrimaryAddress(),
                            account.getSecondaryAccountHolder().getMailingAddress()),
                    account.getCreationDate()
            );
        }
    }
}
