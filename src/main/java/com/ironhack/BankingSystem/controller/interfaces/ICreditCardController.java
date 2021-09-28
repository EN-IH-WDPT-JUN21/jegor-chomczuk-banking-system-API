package com.ironhack.BankingSystem.controller.interfaces;

import com.ironhack.BankingSystem.dao.CreditCard;

import java.util.Optional;

public interface ICreditCardController {
    Optional<CreditCard> getById(Long id);
}
