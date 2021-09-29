package com.ironhack.BankingSystem.service.impl;

import com.ironhack.BankingSystem.controller.dto.CheckingDTO;
import com.ironhack.BankingSystem.dao.StudentChecking;
import com.ironhack.BankingSystem.repository.StudentCheckingRepository;
import com.ironhack.BankingSystem.service.interfaces.IStudentCheckingService;
import com.ironhack.BankingSystem.utils.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentCheckingService implements IStudentCheckingService {

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    UserRetrieveService userRetrieveService;

    @Autowired
    StudentCheckingRepository studentCheckingAccountRepository;

    public StudentChecking createStudentChecking(CheckingDTO checkingAccountDTO) {
        StudentChecking studentCheckingAccount = new StudentChecking(
                new Money(checkingAccountDTO.getBalance(), checkingAccountDTO.getCurrency()),
                passwordEncoder.encode(checkingAccountDTO.getSecretKey()),
                userRetrieveService.retrieveUser(checkingAccountDTO.getAccountHolderId()),
                checkingAccountDTO.getSecondaryAccountHolderId() == null ? null : userRetrieveService.retrieveUser(checkingAccountDTO.getSecondaryAccountHolderId()));
        return studentCheckingAccountRepository.save(studentCheckingAccount);
    }
}
