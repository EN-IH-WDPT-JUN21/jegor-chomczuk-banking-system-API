package com.ironhack.BankingSystem.service.interfaces;

import com.ironhack.BankingSystem.controller.dto.SavingsDTO;
import com.ironhack.BankingSystem.dao.Savings;

import java.util.List;

public interface ISavingsService {
    Savings createSavings(SavingsDTO savingsAccount);
}