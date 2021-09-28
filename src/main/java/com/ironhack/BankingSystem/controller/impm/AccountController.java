package com.ironhack.BankingSystem.controller.impm;

import com.ironhack.BankingSystem.controller.interfaces.IAccountController;
import com.ironhack.BankingSystem.repository.AccountRepository;
import com.ironhack.BankingSystem.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController implements IAccountController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private IAccountService accountService;

    //  Admins should be able to access the balance for any account
//    @GetMapping("/my-accounts/{id}/balance")
//    public BigDecimal getBalance(@PathVariable("id") Long accountId) {
//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(userDetails.getUsername());
//        return accountService.getBalance(accountId, userDetails);
//    }
}