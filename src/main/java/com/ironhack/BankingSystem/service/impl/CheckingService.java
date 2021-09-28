package com.ironhack.BankingSystem.service.impl;

import com.ironhack.BankingSystem.controller.dto.CheckingDTO;
import com.ironhack.BankingSystem.dao.Account;
import com.ironhack.BankingSystem.dao.Checking;
import com.ironhack.BankingSystem.dao.StudentChecking;
import com.ironhack.BankingSystem.repository.CheckingRepository;
import com.ironhack.BankingSystem.repository.StudentCheckingRepository;
import com.ironhack.BankingSystem.service.interfaces.IUserRetrieveService;
import com.ironhack.BankingSystem.utils.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class CheckingService {
    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private IUserRetrieveService userRetrieveService;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Account createCheckingAccount(CheckingDTO checkingDTO) {

        Checking checking = new Checking(
                new Money(checkingDTO.getBalance(), checkingDTO.getCurrency()),
                passwordEncoder.encode(checkingDTO.getSecretKey()),
                userRetrieveService.retrieveUser(checkingDTO.getAccountHolderId()),
                checkingDTO.getSecondaryAccountHolderId() == null ? null : userRetrieveService.retrieveUser(checkingDTO.getSecondaryAccountHolderId()));

        if (ChronoUnit.YEARS.between(checking.getAccountHolder().getDateOfBirth(), LocalDateTime.now()) < 24) {
            StudentChecking studentChecking = new StudentChecking(checking.getBalance(), checking.getSecretKey(), checking.getAccountHolder(), checking.getSecondaryAccountHolder());
            return studentCheckingRepository.save(studentChecking);

        } else {

            return checkingRepository.save(checking);
        }
    }
}
