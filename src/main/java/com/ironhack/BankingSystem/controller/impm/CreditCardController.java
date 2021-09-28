package com.ironhack.BankingSystem.controller.impm;

import com.ironhack.BankingSystem.controller.interfaces.ICreditCardController;
import com.ironhack.BankingSystem.dao.CreditCard;
import com.ironhack.BankingSystem.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class CreditCardController implements ICreditCardController {

    @Autowired
    private CreditCardRepository creditCardRepository;

    //  The AccountHolders should be able to access their own accounts
    //  and only their accounts when passing the correct credentials
    //  using Basic Auth.

    //    Test endpoint: http://localhost:8080/credit-card-account-details/1
    @GetMapping("/credit-card-account-details/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<CreditCard> getById(@PathVariable(name = "id") Long id){
        return creditCardRepository.findById(id);
    }

    //  Admins can create new accounts. When creating a new account
    //  they can create Checking, Savings, or CreditCard Accounts.

    //  Test endpoint: http://localhost:8080/new-credit-card-account
    @PostMapping("/new-credit-card-account")
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard store(@RequestBody @Valid CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }
}
