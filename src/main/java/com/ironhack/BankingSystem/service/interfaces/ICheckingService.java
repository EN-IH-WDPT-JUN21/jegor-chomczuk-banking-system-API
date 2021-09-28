package com.ironhack.BankingSystem.service.interfaces;

import com.ironhack.BankingSystem.controller.dto.CheckingDTO;
import com.ironhack.BankingSystem.dao.Account;

public interface ICheckingService {
    Account createCheckingAccount(CheckingDTO checkingDTO);
}
