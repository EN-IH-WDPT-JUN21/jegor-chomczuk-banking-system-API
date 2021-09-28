package com.ironhack.BankingSystem.controller.dto;

import com.ironhack.BankingSystem.dao.Account;
import com.ironhack.BankingSystem.utils.Address;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class AccountHolderDTO {
    @NotNull
    private Date dateOfBirth;

    @NotNull
    private Address primaryAddress;

    private Address mailingAddress;

    private List<Account> primaryAccountList;

    private List<Account> secondaryAccountList;
}
