package com.ironhack.BankingSystem.controller.interfaces;

import com.ironhack.BankingSystem.dao.Savings;

import java.util.Optional;

public interface ISavingsController {
    Optional<Savings> getById(Long id);
}
