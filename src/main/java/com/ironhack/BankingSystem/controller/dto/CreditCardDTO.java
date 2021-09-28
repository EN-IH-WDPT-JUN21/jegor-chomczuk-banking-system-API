package com.ironhack.BankingSystem.controller.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Currency;

@Getter
@Setter
public class CreditCardDTO {
    @Valid
    private Currency currency;

    @DecimalMax(value = "10000", message = "Max credit limit must be below 10000")
    @DecimalMin(value = "100", message = "Min credit limit must be above 100")
    private BigDecimal creditLimit;

    @DecimalMin(value = "0.1", message = "Min interest rate must be above 0.1")
    private BigDecimal interestRate = new BigDecimal("0.1");

    @NotNull
    @DecimalMin(value = "0", message = "Minimum Balance must be zero or above zero")
    private BigDecimal balance;

    @NotNull
    private String secretKey;

    @NotNull
    @Valid
    private Long accountHolderId;

    @Valid
    private Long secondaryAccountHolderId;
}
