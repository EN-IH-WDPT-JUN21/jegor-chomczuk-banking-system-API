package com.ironhack.BankingSystem.dao;

import com.ironhack.BankingSystem.interfaces.Freezable;
import com.ironhack.BankingSystem.interfaces.Penalizable;
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
public class StudentChecking extends Account implements Freezable, Penalizable {

    @Column(name="secret_key")
    private String secretKey;

    private Money balance;

    @Column(name="creation_date")
    private LocalDateTime creationDate;

    private Status status = Status.ACTIVE;

    public StudentChecking(BigDecimal balance, String secretKey, com.ironhack.BankingSystem.dao.AccountHolder accountHolder, com.ironhack.BankingSystem.dao.AccountHolder secondaryAccountHolder) {
    }

    public StudentChecking(Money balance, String secretKey, com.ironhack.BankingSystem.dao.AccountHolder accountHolder, com.ironhack.BankingSystem.dao.AccountHolder secondaryAccountHolder) {
    }

    @Override
    public Money getMinimumBalance() {
        return null;
    }
}
