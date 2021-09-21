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
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Savings extends Account{

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

    @Column(name="creation_date")
    private Date creationDate;

    @AttributeOverrides({
            @AttributeOverride(name="value",column=@Column(name="interest_rate_value")),
            @AttributeOverride(name="currency",column=@Column(name="interest_rate_currency"))
    })
    private Money interestRate;

    private Status status;

//    Savings accounts have a default interest rate of 0.0025
//    Savings accounts may be instantiated with an interest rate other than the default, with a maximum interest rate of 0.5
//    Savings accounts should have a default minimumBalance of 1000
//    Savings accounts may be instantiated with a minimum balance of less than 1000 but no lower than 100

//    The penaltyFee for all accounts should be 40.
//    If any account drops below the minimumBalance, the penaltyFee should be deducted from the balance automatically

//    Interest on savings accounts is added to the account annually at the rate of specified interestRate per year. That means that if I have 1000000 in a savings account with a 0.01 interest rate, 1% of 1 Million is added to my account after 1 year. When a savings account balance is accessed, you must determine if it has been 1 year or more since either the account was created or since interest was added to the account, and add the appropriate interest to the balance if necessary.
}
