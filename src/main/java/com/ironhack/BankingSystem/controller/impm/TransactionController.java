package com.ironhack.BankingSystem.controller.impm;

import com.ironhack.BankingSystem.controller.interfaces.ITransactionController;
import com.ironhack.BankingSystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController implements ITransactionController {

    @Autowired
    private TransactionRepository transactionRepository;
}
