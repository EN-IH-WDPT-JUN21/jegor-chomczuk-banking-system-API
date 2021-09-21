package com.ironhack.BankingSystem.dao.money;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Money {
    private BigDecimal value;
    private String currency;
}
