package com.ironhack.BankingSystem.controller.impm;

import com.ironhack.BankingSystem.controller.interfaces.IAccountHolderController;
import com.ironhack.BankingSystem.repository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountHolderController implements IAccountHolderController {

    @Autowired
    private AccountHolderRepository accountHolderRepository;
}
