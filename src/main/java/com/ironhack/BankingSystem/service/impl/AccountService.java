package com.ironhack.BankingSystem.service.impl;

import com.ironhack.BankingSystem.dao.Account;
import com.ironhack.BankingSystem.dao.CreditCard;
import com.ironhack.BankingSystem.dao.Savings;
import com.ironhack.BankingSystem.repository.AccountRepository;
import com.ironhack.BankingSystem.service.interfaces.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.server.ResponseStatusException;


import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ITransactionService transactionService;

    public BigDecimal getBalance(Long accountId, UserDetails userDetails) {

        if (accountRepository.findById(accountId).isPresent()) {
            Account account = accountRepository.findById(accountId).get();
            if (account.getAccountHolder().getUsername().equals(userDetails.getUsername()) || account.getSecondaryAccountHolder().getUsername().equals(userDetails.getUsername())) {
                if (account instanceof CreditCard) transactionService.applyInterestRate((CreditCard) account);
                if (account instanceof Savings) transactionService.applyInterestRate((Savings) account);
                return account.getBalance().getAmount();
            } else {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You don't have permissions for this account");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account with id " + accountId + " doesn't exist in the database");

        }
    }

}
