package com.ironhack.BankingSystem.dao.accounts;

import com.ironhack.BankingSystem.dao.users.AccountHolder;
import com.ironhack.BankingSystem.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard extends Account {

    private BigDecimal balance;

    //  CreditCard accounts have a default creditLimit of 100
    private BigDecimal creditLimit = Constants.CCARD_DEFAULT_CREDIT_LIMIT;

    //  CreditCards have a default interestRate of 0.2
    private BigDecimal interestRate = Constants.CCARD_DEFAULT_INTEREST_RATE;

    @Column(name = "creation_date")
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(name = "last_interest_add_date")
    private LocalDateTime lastInterestAddDate = creationDate;

    //  Setters
    //  CreditCards may be instantiated with a creditLimit higher than 100 but not higher than 100000
    public BigDecimal setCreditLimit(BigDecimal creditLimit) {
        if (creditLimit.compareTo(Constants.CCARD_DEFAULT_CREDIT_LIMIT) >= 0
                && (creditLimit.compareTo(BigDecimal.valueOf(100000)) <= 0)) {
            this.creditLimit = creditLimit;

        } else if (creditLimit.compareTo(Constants.CCARD_DEFAULT_CREDIT_LIMIT) < 0) {
            this.creditLimit = Constants.CCARD_DEFAULT_CREDIT_LIMIT;

        } else if (creditLimit.compareTo(BigDecimal.valueOf(100000)) > 0) {
            this.creditLimit = BigDecimal.valueOf(100000);
        }
        return this.creditLimit;
    }

    //  CreditCards may be instantiated with an interestRate less than 0.2 but not lower than 0.1
    public BigDecimal setInterestRate(BigDecimal interestRate) {
        if ((interestRate.compareTo(BigDecimal.valueOf(0.1)) >= 0)
                && interestRate.compareTo(Constants.CCARD_DEFAULT_INTEREST_RATE) <= 0) {
            this.interestRate = interestRate;

        } else if (interestRate.compareTo(Constants.CCARD_DEFAULT_INTEREST_RATE) > 0) {
            this.interestRate = Constants.CCARD_DEFAULT_INTEREST_RATE;

        } else if (interestRate.compareTo(BigDecimal.valueOf(0.1)) < 0) {
            this.interestRate = BigDecimal.valueOf(0.1);
        }
        return this.interestRate;
    }

    //  Interest on credit cards is added to the balance monthly. If you have a 12% interest rate (0.12)
    //  then 1% interest will be added to the account monthly. When the balance of a credit card is accessed,
    //  check to determine if it has been 1 month or more since the account was created or since interested was added,
    //  and if so, add the appropriate interest to the balance.
    public BigDecimal getBalance() {
        LocalDateTime actualTime = LocalDateTime.now();
        long months = ChronoUnit.MONTHS.between(lastInterestAddDate, actualTime);
        BigDecimal monthlyInterestRate = getInterestRate().divide(BigDecimal.valueOf(12));
        for (long i = 0; i < months; i++ ){
            setBalance(balance.add(balance.multiply(monthlyInterestRate)));
        }
        setLastInterestAddDate(actualTime);
        return balance;
    }

    //  Constructors
    //  with custom creditLimit and interestRate
    public CreditCard(BigDecimal penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal balance, BigDecimal creditLimit, BigDecimal interestRate) {
        super(penaltyFee, primaryOwner, secondaryOwner);
        this.balance = balance;
        this.creditLimit = setCreditLimit(creditLimit);
        this.interestRate = setInterestRate(interestRate);
    }

    //  with default creditLimit and interestRate
    public CreditCard(BigDecimal penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal balance) {
        super(penaltyFee, primaryOwner, secondaryOwner);
        this.balance = balance;
    }
}