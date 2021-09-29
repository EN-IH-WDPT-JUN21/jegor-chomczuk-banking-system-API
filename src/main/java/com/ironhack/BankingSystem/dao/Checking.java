package com.ironhack.BankingSystem.dao;

import com.ironhack.BankingSystem.enums.Status;
import com.ironhack.BankingSystem.interfaces.Freezable;
import com.ironhack.BankingSystem.interfaces.Penalizable;
import com.ironhack.BankingSystem.utils.Constants;
import com.ironhack.BankingSystem.utils.Money;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(name = "accountId")
public class Checking extends Account implements Freezable, Penalizable {

    LocalDateTime maintenanceFeeLastTimeApplied;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance_amount"))
    })
    private Money minimumBalance;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "monthly_maintenance_fee_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "monthly_maintenance_fee_amount"))
    })
    private Money monthlyMaintenanceFee;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    public Checking() {
    }


    public Checking(Money balance, String secretKey, @NotNull @Valid AccountHolder accountHolder, @Valid AccountHolder secondaryAccountHolder) {
        super(balance, secretKey, accountHolder, secondaryAccountHolder);
        this.minimumBalance = new Money(Constants.CHECKING_ACC_MIN_BALANCE);
        this.monthlyMaintenanceFee = new Money(Constants.CHECKING_ACC_DEFFAULT_MONTHLY_FEE);
        status = Status.ACTIVE;
        maintenanceFeeLastTimeApplied = LocalDateTime.now();
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Money getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(Money monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getMaintenanceFeeLastTimeApplied() {
        return maintenanceFeeLastTimeApplied;
    }

    public void setMaintenanceFeeLastTimeApplied(LocalDateTime maintenanceFeeLastTimeApplied) {
        this.maintenanceFeeLastTimeApplied = maintenanceFeeLastTimeApplied;
    }
}
