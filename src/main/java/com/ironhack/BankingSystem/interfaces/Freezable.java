package com.ironhack.BankingSystem.interfaces;

import com.ironhack.BankingSystem.enums.Status;

public interface Freezable {

    Status getStatus();

    void setStatus(Status status);

    Long getAccountId();
}