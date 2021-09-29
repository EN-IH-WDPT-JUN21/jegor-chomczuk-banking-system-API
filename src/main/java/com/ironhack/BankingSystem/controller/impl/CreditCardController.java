package com.ironhack.BankingSystem.controller.impl;

import com.ironhack.BankingSystem.controller.dto.CreditCardDTO;
import com.ironhack.BankingSystem.controller.interfaces.ICreditCardController;
import com.ironhack.BankingSystem.dao.CreditCard;
import com.ironhack.BankingSystem.service.interfaces.ICreditCardService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.context.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.*;

@RestController
public class CreditCardController implements ICreditCardController {

    @Autowired
    ICreditCardService creditCardService;

    @PostMapping("/credit-card/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard createCreditCard (@RequestBody @Valid CreditCardDTO creditCard) {
        return creditCardService.createCreditCard(creditCard);
    }
}