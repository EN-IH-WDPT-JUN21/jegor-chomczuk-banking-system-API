package com.ironhack.BankingSystem.service.interfaces;

import com.ironhack.BankingSystem.controller.dto.TransactionDTO;
import com.ironhack.BankingSystem.utils.Money;
import org.springframework.security.core.userdetails.UserDetails;

public interface ITransactionService {
    Money transferMoney(UserDetails userDetails, TransactionDTO transactionDTO);
}
