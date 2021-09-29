package com.ironhack.BankingSystem.controller.impl;

import com.ironhack.BankingSystem.controller.dto.TransactionDTO;
import com.ironhack.BankingSystem.controller.interfaces.ITransactionController;
import com.ironhack.BankingSystem.service.interfaces.ITransactionService;
import com.ironhack.BankingSystem.utils.Money;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.context.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;

@RestController
public class TransactionController implements ITransactionController {

    @Autowired
    ITransactionService transactionService;

    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.OK)
    public Money sendMoney(@RequestBody @Valid TransactionDTO transactionDTO) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return transactionService.transferMoney(userDetails, transactionDTO);
    }
}