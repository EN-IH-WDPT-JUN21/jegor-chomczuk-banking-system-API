package com.ironhack.BankingSystem.controller.interfaces;

import com.ironhack.BankingSystem.dao.StudentChecking;

import java.util.Optional;

public interface IStudentCheckingController {
    Optional<StudentChecking> getById(Long id);
}
