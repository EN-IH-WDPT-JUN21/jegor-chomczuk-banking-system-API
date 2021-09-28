package com.ironhack.BankingSystem.controller.interfaces;

import com.ironhack.BankingSystem.dao.Checking;

import java.util.Optional;

public interface ICheckingController {
    Optional<Checking> getById(Long id);
}
