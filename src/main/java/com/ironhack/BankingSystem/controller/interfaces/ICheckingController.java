package com.ironhack.BankingSystem.controller.interfaces;

import com.ironhack.BankingSystem.controller.dto.CheckingDTO;
import com.ironhack.BankingSystem.dao.Account;
import com.ironhack.BankingSystem.dao.Checking;

import java.util.List;

public interface ICheckingController {
    List<Checking> getAllCheckingAccounts();
    Account createCheckingAccount(CheckingDTO checkingAccount);
    Checking updateCheckingAccount(Long id, Checking checkingAccount);
}
