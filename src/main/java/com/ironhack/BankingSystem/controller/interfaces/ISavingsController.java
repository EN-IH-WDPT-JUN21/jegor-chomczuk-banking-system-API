package com.ironhack.BankingSystem.controller.interfaces;

import com.ironhack.BankingSystem.controller.dto.SavingsDTO;
import com.ironhack.BankingSystem.dao.Savings;

import java.util.List;

public interface ISavingsController {
    Savings createSavings(SavingsDTO savingsAccount);
}