package com.ironhack.BankingSystem.dao;

import com.ironhack.BankingSystem.interfaces.Freezable;
import com.ironhack.BankingSystem.interfaces.Penalizable;
import com.ironhack.BankingSystem.utils.Constants;
import com.ironhack.BankingSystem.enums.Status;
import com.ironhack.BankingSystem.utils.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Savings extends Account implements Freezable, Penalizable {

    @Column(name = "secret_key")
    private String secretKey;

    private Money balance;

    //    Savings accounts should have a default minimumBalance of 1000
    @Column(name = "minimum_balance")
    private Money minimumBalance = new Money (Constants.SAVINGS_ACC_DEFAULT_MIN_BALANCE);

    @Column(name = "creation_date")
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(name = "last_interest_add_date")
    private LocalDateTime lastInterestsApplied = creationDate;

    //    Savings accounts have a default interest rate of 0.0025
    private BigDecimal interestRate = Constants.SAVINGS_ACC_DEFAULT_INTEREST_RATE;

    private Status status = Status.ACTIVE;
//
//    //    Savings accounts may be instantiated with an interest rate other than the default, with a maximum interest rate of 0.5
//    public BigDecimal setInterestRate(BigDecimal interestRate) {
//        if (interestRate.compareTo(BigDecimal.valueOf(0.5)) <= 0) {
//            this.interestRate = interestRate;
//
//        } else {
//            this.interestRate = (BigDecimal.valueOf(0.5));
//
//        }
//        return this.interestRate;
//    }
//
//    //    Savings accounts may be instantiated with a minimum balance of less than 1000 but no lower than 100
//    public BigDecimal setMinimumBalance(BigDecimal minimumBalance) {
//        if (minimumBalance.compareTo(BigDecimal.valueOf(100)) >= 0
//                && minimumBalance.compareTo(Constants.SAVINGS_ACC_DEFAULT_MIN_BALANCE) <= 0) {
//            this.minimumBalance = minimumBalance;
//
//        } else if (minimumBalance.compareTo(BigDecimal.valueOf(100)) < 0) {
//            this.minimumBalance = BigDecimal.valueOf(100);
//
//        } else if (minimumBalance.compareTo(Constants.SAVINGS_ACC_DEFAULT_MIN_BALANCE) > 0) {
//            this.minimumBalance = Constants.SAVINGS_ACC_DEFAULT_MIN_BALANCE;
//
//        }
//        return this.minimumBalance;
//    }
//
//    //  If any account drops below the minimumBalance, the penaltyFee should be deducted from the balance automatically
//    public void setBalance(BigDecimal balance) {
//        MathContext mc = new MathContext(2);
//        BigDecimal newBalance = null;
//        if (balance.compareTo(Constants.SAVINGS_ACC_DEFAULT_MIN_BALANCE) < 0) {
//            newBalance = balance.subtract(Constants.PENALTY_FEE);
//        }
//        this.balance = newBalance;
//    }
//
//    //  Interest on savings accounts is added to the account annually at the rate of specified interestRate per year.
//    //  That means that if I have 1000000 in a savings account with a 0.01 interest rate, 1% of 1 Million is added to
//    //  my account after 1 year. When a savings account balance is accessed, you must determine if it has been 1 year
//    //  or more since either the account was created or since interest was added to the account, and add the appropriate
//    //  interest to the balance if necessary.
//    public BigDecimal getBalance() {
//        LocalDateTime actualTime = LocalDateTime.now();
//        long years = ChronoUnit.YEARS.between(lastInterestAddDate, actualTime);
//        for (long i = 0; i < years; i++ ){
//            setBalance(balance.add(balance.multiply(getInterestRate())));
//        }
//        setLastInterestAddDate(actualTime);
//        return balance;
//    }
//
//    //  Constructors
//    //  with custom interestRate and minimumBalance
//    public Savings(BigDecimal penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey, BigDecimal balance, BigDecimal minimumBalance, BigDecimal interestRate) {
//        super(penaltyFee, primaryOwner, secondaryOwner);
//        this.secretKey = secretKey;
//        this.balance = balance;
//        this.minimumBalance = setMinimumBalance(minimumBalance);
//        this.interestRate = setInterestRate(interestRate);
//    }
//
//    //  with default interestRate and minimumBalance
//    public Savings(BigDecimal penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey, BigDecimal balance) {
//        super(penaltyFee, primaryOwner, secondaryOwner);
//        this.secretKey = secretKey;
//        this.balance = balance;
//    }
}
