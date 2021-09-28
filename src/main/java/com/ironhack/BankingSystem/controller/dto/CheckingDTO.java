package com.ironhack.BankingSystem.controller.dto;

import com.ironhack.BankingSystem.enums.Status;
import com.ironhack.BankingSystem.utils.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Getter
@Setter
public class CheckingDTO {

    @Valid
    private Currency currency;

    @NotNull
    private String secretKey;

    @NotNull
    @DecimalMin(value = "0", message = "Minimum Balance must be zero or above zero")
    private BigDecimal balance;

    @NotNull
    private BigDecimal minimumBalance = Constants.CHECKING_ACC_MIN_BALANCE;

    @NotNull
    private BigDecimal monthlyMaintenanceFee = Constants.CHECKING_ACC_DEFFAULT_MONTHLY_FEE;

    @NotNull
    @Valid
    private Long accountHolderId;

    @Valid
    private Long secondaryAccountHolderId;
}
