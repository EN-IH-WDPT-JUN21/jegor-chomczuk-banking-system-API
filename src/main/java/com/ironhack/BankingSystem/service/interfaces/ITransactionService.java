package com.ironhack.BankingSystem.service.interfaces;

import com.ironhack.BankingSystem.dao.CreditCard;
import com.ironhack.BankingSystem.dao.Savings;

public interface ITransactionService {
    CreditCard applyInterestRate(CreditCard creditCard);
    Savings applyInterestRate(Savings savings);
}
