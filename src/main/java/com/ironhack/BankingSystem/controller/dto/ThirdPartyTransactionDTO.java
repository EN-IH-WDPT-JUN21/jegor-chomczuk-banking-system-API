package com.ironhack.BankingSystem.controller.dto;

import com.ironhack.BankingSystem.dao.Account;
import com.ironhack.BankingSystem.dao.ThirdParty;
import com.ironhack.BankingSystem.utils.Money;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Currency;

@Setter
@Getter
public class ThirdPartyTransactionDTO {
    @NotNull
    private String secretKey;

    @NotNull
    private long thirdPartyId;

    @NotNull
    private Account account;

    @Valid
    private Currency currency;

    @Valid
    ThirdParty thirdParty;

    @NotNull
    private LocalDateTime timeStamp;

    @NotNull
    private Money amount;

    @NotNull
    private String hashedKey;

    @NotNull
    private long accountId;

}
