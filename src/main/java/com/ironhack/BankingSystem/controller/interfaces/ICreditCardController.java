package com.ironhack.BankingSystem.controller.interfaces;

import com.ironhack.BankingSystem.controller.dto.CreditCardDTO;
import com.ironhack.BankingSystem.dao.CreditCard;

import java.util.List;

public interface ICreditCardController {
    CreditCard createCreditCard(CreditCardDTO creditCard);
}
