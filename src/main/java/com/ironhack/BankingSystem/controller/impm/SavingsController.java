package com.ironhack.BankingSystem.controller.impm;

import com.ironhack.BankingSystem.controller.interfaces.ISavingsController;
import com.ironhack.BankingSystem.dao.Savings;
import com.ironhack.BankingSystem.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class SavingsController implements ISavingsController {

    @Autowired
    private SavingsRepository savingsRepository;

    //  The AccountHolders should be able to access their own accounts
    //  and only their accounts when passing the correct credentials
    //  using Basic Auth.

    //    Test endpoint: http://localhost:8080/savings-account-details/1
    @GetMapping("/savings-account-details/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Savings> getById(@PathVariable(name = "id") Long id){
        return savingsRepository.findById(id);
    }

    //  Admins can create new accounts. When creating a new account
    //  they can create Checking, Savings, or CreditCard Accounts.

    //  Test endpoint: http://localhost:8080/new-savings-account
    @PostMapping("/new-savings-account")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings store(@RequestBody @Valid Savings savings) {
        return savingsRepository.save(savings);
    }
}
