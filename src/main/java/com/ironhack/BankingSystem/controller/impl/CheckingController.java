package com.ironhack.BankingSystem.controller.impl;

import com.ironhack.BankingSystem.controller.dto.CheckingDTO;
import com.ironhack.BankingSystem.controller.interfaces.ICheckingController;
import com.ironhack.BankingSystem.dao.Account;
import com.ironhack.BankingSystem.dao.Checking;
import com.ironhack.BankingSystem.service.interfaces.ICheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CheckingController implements ICheckingController {

    @Autowired
    ICheckingService checkingAccountService;

    @GetMapping("/admin/checking-accounts")
    public List<Checking> getAllCheckingAccounts() {
        return checkingAccountService.getAllCheckingAccounts();
    }

    @PostMapping("/admin/checking-account/new/")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createCheckingAccount(@RequestBody @Valid CheckingDTO checkingAccount) {
        return checkingAccountService.createCheckingAccount(checkingAccount);
    }

    @PostMapping("/admin/checking-account/{id}")
    public Checking updateCheckingAccount(@PathVariable Long id, @RequestBody Checking checkingAccount) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return checkingAccountService.updateCheckingAccount(id, checkingAccount);
    }
}