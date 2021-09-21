package com.ironhack.BankingSystem.dao.accounnts;

import com.ironhack.BankingSystem.dao.money.Money;
import com.ironhack.BankingSystem.enums.Status;
import com.ironhack.BankingSystem.dao.users.AccountHolder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Checking extends Account{

    @Column(name="secret_key")
    private String secretKey;

    @Column(name="minimum_balance")
    @AttributeOverrides({
            @AttributeOverride(name="value",column=@Column(name="minimum_balance_value")),
            @AttributeOverride(name="currency",column=@Column(name="minimum_balance_currency"))
    })
    private Money minimumBalance;

    @Column(name="penalty_fee")
    @AttributeOverrides({
            @AttributeOverride(name="value",column=@Column(name="penalty_fee_value")),
            @AttributeOverride(name="currency",column=@Column(name="penalty_fee_currency"))
    })
    private Money penaltyFee;

    @Column(name="monthly_maintenance_fee")
    @AttributeOverrides({
            @AttributeOverride(name="value",column=@Column(name="monthly_maintenance_fee_value")),
            @AttributeOverride(name="currency",column=@Column(name="monthly_maintenance_fee_currency"))
    })
    private Money monthlyMaintenanceFee;

    @Column(name="creation_date")
    private Date creationDate;

    private Status status;

//    When creating a new Checking account, if the primaryOwner is less than 24, a StudentChecking account should be created otherwise a regular Checking Account should be created.
//    Checking accounts should have a minimumBalance of 250 and a monthlyMaintenanceFee of 12

//    The penaltyFee for all accounts should be 40.
//    If any account drops below the minimumBalance, the penaltyFee should be deducted from the balance automatically
}