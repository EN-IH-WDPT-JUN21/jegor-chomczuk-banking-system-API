package com.ironhack.BankingSystem.controller.interfaces;

import com.ironhack.BankingSystem.controller.dto.TransactionDTO;
import com.ironhack.BankingSystem.utils.Money;

public interface ITransactionController {
    Money sendMoney(TransactionDTO transactionDTO);
}
