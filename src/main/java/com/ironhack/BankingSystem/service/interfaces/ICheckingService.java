package com.ironhack.BankingSystem.service.interfaces;

import com.ironhack.BankingSystem.controller.dto.CheckingDTO;
import com.ironhack.BankingSystem.dao.Account;
import com.ironhack.BankingSystem.dao.Checking;

import java.util.List;

public interface ICheckingService {
    Account createCheckingAccount(CheckingDTO checkingAccount);
    Checking updateCheckingAccount(Long id, Checking checkingAccount);
    List<Checking> getAllCheckingAccounts();
}
