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
import java.math.MathContext;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Checking extends Account implements Freezable, Penalizable{

    @Column(name = "secret_key")
    private String secretKey;

    //    Checking accounts should have a minimumBalance of 250
    @Column(name = "minimum_balance")
    private Money minimumBalance = new Money (Constants.CHECKING_ACC_MIN_BALANCE);

    //    Checking accounts should have a monthlyMaintenanceFee of 12
    @Column(name = "monthly_maintenance_fee")
    private Money monthlyMaintenanceFee = new Money (Constants.CHECKING_ACC_DEFFAULT_MONTHLY_FEE);

    @Column(name = "creation_date")
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column(name = "last_monthly_fee_applied")
    private LocalDateTime lastMonthlyFeeApplied = creationDate;

    private Status status = Status.ACTIVE;

//    public Checking(Money money, String encode, User retrieveUser, User user) {
//    }
//
//    //  If any account drops below the minimumBalance, the penaltyFee should be deducted from the balance automatically
//    public void setBalance(BigDecimal balance) {
//        MathContext mc = new MathContext(2);
//        BigDecimal newBalance = null;
//        if (balance.compareTo(Constants.CHECKING_ACC_MIN_BALANCE) < 0) {
//            newBalance = balance.subtract(Constants.PENALTY_FEE);
//        }
//        this.balance = new Money(newBalance);
//    }
}