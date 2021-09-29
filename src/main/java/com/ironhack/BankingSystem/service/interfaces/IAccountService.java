package com.ironhack.BankingSystem.service.interfaces;

import com.ironhack.BankingSystem.controller.dto.AccountInfoDTO;
import com.ironhack.BankingSystem.utils.Money;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface IAccountService {
    AccountInfoDTO getAccountById(Long id);
    Money getBalanceById(Long id);
    void updateBalance(Long accountId, Money money);
    Money getBalance(Long accountId, UserDetails userDetails);
}