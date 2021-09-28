package com.ironhack.BankingSystem.service.impl;

import com.ironhack.BankingSystem.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsService {

    @Autowired
    private SavingsRepository savingsRepository;

}
