package com.ironhack.BankingSystem.service.impl;

import com.ironhack.BankingSystem.repository.ThirdPartyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyTransactionService {

    @Autowired
    private ThirdPartyTransactionRepository thirdPartyTransactionRepository;

}
