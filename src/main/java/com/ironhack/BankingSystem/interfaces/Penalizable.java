package com.ironhack.BankingSystem.interfaces;

import com.ironhack.BankingSystem.utils.Money;

public interface Penalizable {
    Long getAccountId();
    Money getMinimumBalance();
    Money getBalance();
    void setBalance(Money money);
}