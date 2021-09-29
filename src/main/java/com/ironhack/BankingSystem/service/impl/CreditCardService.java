package com.ironhack.BankingSystem.service.impl;

import com.ironhack.BankingSystem.controller.dto.CreditCardDTO;
import com.ironhack.BankingSystem.dao.CreditCard;
import com.ironhack.BankingSystem.repository.CreditCardRepository;
import com.ironhack.BankingSystem.service.interfaces.ICreditCardService;
import com.ironhack.BankingSystem.utils.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CreditCardService implements ICreditCardService {
    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    UserRetrieveService userRetrieveService;

    public CreditCard createCreditCard(CreditCardDTO creditCardDTO) {

        return creditCardRepository.save(
                new CreditCard(
                        new Money(creditCardDTO.getBalance()),
                        creditCardDTO.getSecretKey(),
                        userRetrieveService.retrieveUser(creditCardDTO.getAccountHolderId()),
                        creditCardDTO.getSecondaryAccountHolderId() == null ? null : userRetrieveService.retrieveUser(creditCardDTO.getSecondaryAccountHolderId()),
                        new Money(creditCardDTO.getCreditLimit()),
                        creditCardDTO.getInterestRate()));
    }
}