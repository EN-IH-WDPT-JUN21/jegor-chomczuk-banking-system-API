package com.ironhack.BankingSystem.controller.interfaces;

import com.ironhack.BankingSystem.controller.dto.CheckingDTO;
import com.ironhack.BankingSystem.dao.StudentChecking;

import java.util.List;

public interface IStudentCheckingController {
    StudentChecking createStudentChecking(CheckingDTO studentCheckingAccount);
}
