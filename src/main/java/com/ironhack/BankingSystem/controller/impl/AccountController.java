package com.ironhack.BankingSystem.controller.impl;

import com.ironhack.BankingSystem.controller.dto.AccountInfoDTO;
import com.ironhack.BankingSystem.controller.interfaces.IAccountController;
import com.ironhack.BankingSystem.service.interfaces.IAccountService;
import com.ironhack.BankingSystem.utils.Money;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.context.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@RestController
public class AccountController implements IAccountController {

    @Autowired
    IAccountService accountService;

    @GetMapping("/admin/account/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountInfoDTO getAccountById(@PathVariable("id") Long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/admin/account/{id}/balance")
    @ResponseStatus(HttpStatus.OK)
    public Money getBalanceById(@PathVariable("id") Long id) {
        return accountService.getBalanceById(id);
    }

    @PostMapping("/admin/account/{id}/balance")
    @ResponseStatus(HttpStatus.OK)
    public void updateBalance(@PathVariable("id") Long accountId, @RequestBody @Valid Money money) {
        accountService.updateBalance(accountId, money);
    }

    @GetMapping("/my-accounts/{id}/balance")
    public Money getBalance(@PathVariable("id") Long accountId) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userDetails.getUsername());
        return accountService.getBalance(accountId, userDetails);
    }
}