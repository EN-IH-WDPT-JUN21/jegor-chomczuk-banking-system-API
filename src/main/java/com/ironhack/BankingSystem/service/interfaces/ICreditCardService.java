package com.ironhack.BankingSystem.service.interfaces;

import com.ironhack.BankingSystem.controller.dto.CreditCardDTO;
import com.ironhack.BankingSystem.dao.CreditCard;

import java.util.List;

public interface ICreditCardService {
    CreditCard createCreditCard(CreditCardDTO creditCard);
}