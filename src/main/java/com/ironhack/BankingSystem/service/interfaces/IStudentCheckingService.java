package com.ironhack.BankingSystem.service.interfaces;

import com.ironhack.BankingSystem.controller.dto.CheckingDTO;
import com.ironhack.BankingSystem.dao.StudentChecking;

import java.util.List;

public interface IStudentCheckingService {
    StudentChecking createStudentChecking(CheckingDTO studentCheckingAccount);
}
