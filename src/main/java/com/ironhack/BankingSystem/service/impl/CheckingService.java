package com.ironhack.BankingSystem.service.impl;

import com.ironhack.BankingSystem.controller.dto.CheckingDTO;
import com.ironhack.BankingSystem.dao.Account;
import com.ironhack.BankingSystem.dao.Checking;
import com.ironhack.BankingSystem.dao.StudentChecking;
import com.ironhack.BankingSystem.repository.CheckingRepository;
import com.ironhack.BankingSystem.repository.StudentCheckingRepository;
import com.ironhack.BankingSystem.service.interfaces.ICheckingService;
import com.ironhack.BankingSystem.utils.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class CheckingService implements ICheckingService {

    @Autowired
    CheckingRepository checkingAccountRepository;

    @Autowired
    StudentCheckingRepository studentCheckingAccountRepository;

    @Autowired
    UserRetrieveService userRetrieveService;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Account createCheckingAccount(CheckingDTO checkingAccountDTO) {
        Checking checkingAccount = new Checking(
                new Money(checkingAccountDTO.getBalance(), checkingAccountDTO.getCurrency()),
                passwordEncoder.encode(checkingAccountDTO.getSecretKey()),
                userRetrieveService.retrieveUser(checkingAccountDTO.getAccountHolderId()),
                checkingAccountDTO.getSecondaryAccountHolderId() == null ? null : userRetrieveService.retrieveUser(checkingAccountDTO.getSecondaryAccountHolderId()));
        if (ChronoUnit.YEARS.between(checkingAccount.getAccountHolder().getDateOfBirth(), LocalDateTime.now()) < 24) {
            StudentChecking studentCheckingAccount = new StudentChecking(checkingAccount.getBalance(), checkingAccount.getSecretKey(), checkingAccount.getAccountHolder(), checkingAccount.getSecondaryAccountHolder());
            return studentCheckingAccountRepository.save(studentCheckingAccount);
        } else {
            return checkingAccountRepository.save(checkingAccount);
        }
    }

    public Checking updateCheckingAccount(Long id, Checking checkingAccount) {
        if (checkingAccountRepository.findById(id).isPresent()) {
            checkingAccount.setAccountId(checkingAccountRepository.findById(id).get().getAccountId());
            return checkingAccountRepository.save((Checking) checkingAccount);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Checking account with id " + id + " doesn't in the database");

        }
    }

    public List<Checking> getAllCheckingAccounts() {
        return checkingAccountRepository.findAll();
    }
}