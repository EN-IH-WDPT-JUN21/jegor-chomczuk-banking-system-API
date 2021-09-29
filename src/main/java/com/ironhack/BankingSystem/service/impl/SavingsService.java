package com.ironhack.BankingSystem.service.impl;

import com.ironhack.BankingSystem.controller.dto.SavingsDTO;
import com.ironhack.BankingSystem.dao.Savings;
import com.ironhack.BankingSystem.repository.SavingsRepository;
import com.ironhack.BankingSystem.service.interfaces.ISavingsService;
import com.ironhack.BankingSystem.utils.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SavingsService implements ISavingsService {

    @Autowired
    SavingsRepository savingsAccountRepository;

    @Autowired
    UserRetrieveService userRetrieveService;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Savings createSavings(SavingsDTO savingsAccountDTO) {

        return savingsAccountRepository.save(new Savings(
                new Money(savingsAccountDTO.getBalance(), savingsAccountDTO.getCurrency()),
                passwordEncoder.encode(savingsAccountDTO.getSecretKey()),
                userRetrieveService.retrieveUser(savingsAccountDTO.getAccountHolderId()),
                savingsAccountDTO.getSecondaryAccountHolderId() == null ? null : userRetrieveService.retrieveUser(savingsAccountDTO.getSecondaryAccountHolderId()),
                savingsAccountDTO.getInterestRate(),
                new Money(savingsAccountDTO.getMinimumBalance(), savingsAccountDTO.getCurrency())
        ));
    }
}
