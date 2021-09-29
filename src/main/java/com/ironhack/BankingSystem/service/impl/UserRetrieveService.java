package com.ironhack.BankingSystem.service.impl;

import com.ironhack.BankingSystem.dao.AccountHolder;
import com.ironhack.BankingSystem.repository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserRetrieveService {
    @Autowired
    AccountHolderRepository accountHolderRepository;

    public AccountHolder retrieveUser(Long id) {

        if (!accountHolderRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Checking account with id " + id + " doesn't in the database");
        } else {
            return accountHolderRepository.findById(id).get();
        }
    }
}