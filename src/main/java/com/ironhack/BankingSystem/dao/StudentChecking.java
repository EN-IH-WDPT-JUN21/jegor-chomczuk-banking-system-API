package com.ironhack.BankingSystem.dao;

import com.ironhack.BankingSystem.enums.Status;
import com.ironhack.BankingSystem.interfaces.Freezable;
import com.ironhack.BankingSystem.utils.Money;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "accountId")
@Table(name = "student_checking_account")
public class StudentChecking extends Account implements Freezable {

    @Enumerated
    private Status status;

    public StudentChecking() {
        status = Status.ACTIVE;
    }

    public StudentChecking(Money balance, String secretKey, @NotNull @Valid AccountHolder accountHolder, @Valid AccountHolder secondaryAccountHolder) {
        super(balance, secretKey, accountHolder, secondaryAccountHolder);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
