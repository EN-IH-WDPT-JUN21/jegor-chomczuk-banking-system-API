package com.ironhack.BankingSystem.controller.impl;

import com.ironhack.BankingSystem.controller.dto.SavingsDTO;
import com.ironhack.BankingSystem.controller.interfaces.ISavingsController;
import com.ironhack.BankingSystem.dao.Savings;
import com.ironhack.BankingSystem.service.interfaces.ISavingsService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@RestController
public class SavingsController implements ISavingsController {

    @Autowired
    ISavingsService savingsAccountService;

    @PostMapping("/admin/savings-account/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings createSavings (@RequestBody @Valid SavingsDTO savingsAccount) {
        return savingsAccountService.createSavings(savingsAccount);
    }
}