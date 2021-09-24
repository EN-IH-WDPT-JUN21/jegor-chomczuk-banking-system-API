package com.ironhack.BankingSystem.dao.accounts;

import com.ironhack.BankingSystem.utils.Constants;
import com.ironhack.BankingSystem.enums.Status;
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
public class Checking extends Account {

    @Column(name = "secret_key")
    private String secretKey;

    private BigDecimal balance;

    //    Checking accounts should have a minimumBalance of 250
    @Column(name = "minimum_balance")
    private BigDecimal minimumBalance = Constants.CHECKING_ACC_MIN_BALANCE;

    //    Checking accounts should have a monthlyMaintenanceFee of 12
    @Column(name = "monthly_maintenance_fee")
    private BigDecimal monthlyMaintenanceFee = Constants.CHECKING_ACC_DEFFAULT_MONTHLY_FEE;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    private Status status = Status.ACTIVE;

    //  If any account drops below the minimumBalance, the penaltyFee should be deducted from the balance automatically
    public void setBalance(BigDecimal balance) {
        MathContext mc = new MathContext(2);
        BigDecimal newBalance = null;
        if (balance.compareTo(Constants.CHECKING_ACC_MIN_BALANCE) < 0) {
            newBalance = balance.subtract(Constants.PENALTY_FEE);
        }
        this.balance = newBalance;
    }
}