package com.ironhack.BankingSystem.dao.accounnts;

import com.ironhack.BankingSystem.dao.money.Money;
import com.ironhack.BankingSystem.dao.users.AccountHolder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditCard extends Account{

    @AttributeOverrides({
            @AttributeOverride(name="value",column=@Column(name="credit_limit_value")),
            @AttributeOverride(name="currency",column=@Column(name="credit_limit_currency"))
    })
    private Money creditLimit;

    @AttributeOverrides({
            @AttributeOverride(name="value",column=@Column(name="interest_rate_value")),
            @AttributeOverride(name="currency",column=@Column(name="interest_rate_currency"))
    })
    private Money interestRate;

    @AttributeOverrides({
            @AttributeOverride(name="value",column=@Column(name="penalty_fee_value")),
            @AttributeOverride(name="currency",column=@Column(name="penalty_fee_currency"))
    })
    private Money penaltyFee;

//    CreditCard accounts have a default creditLimit of 100
//    CreditCards may be instantiated with a creditLimit higher than 100 but not higher than 100000
//    CreditCards have a default interestRate of 0.2
//    CreditCards may be instantiated with an interestRate less than 0.2 but not lower than 0.1

//    The penaltyFee for all accounts should be 40.
//    If any account drops below the minimumBalance, the penaltyFee should be deducted from the balance automatically


//    Interest on credit cards is added to the balance monthly. If you have a 12% interest rate (0.12) then 1% interest will be added to the account monthly. When the balance of a credit card is accessed, check to determine if it has been 1 month or more since the account was created or since interested was added, and if so, add the appropriate interest to the balance.
}