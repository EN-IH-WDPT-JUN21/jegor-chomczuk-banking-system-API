package com.ironhack.BankingSystem.controller.interfaces;

import com.ironhack.BankingSystem.controller.dto.AccountInfoDTO;
import com.ironhack.BankingSystem.utils.Money;

import java.util.List;

public interface IAccountController {
    AccountInfoDTO getAccountById(Long id);
    Money getBalanceById(Long id);
    void updateBalance(Long accountId, Money money);
    Money getBalance(Long id);
}
