package com.ironhack.BankingSystem.service.interfaces;

import org.springframework.security.core.userdetails.*;

import java.math.BigDecimal;

public interface IAccountService {
    BigDecimal getBalance(Long accountId, UserDetails userDetails);
}
