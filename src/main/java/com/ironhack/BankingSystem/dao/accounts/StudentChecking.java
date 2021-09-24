package com.ironhack.BankingSystem.dao.accounts;

import com.ironhack.BankingSystem.dao.users.AccountHolder;
import com.ironhack.BankingSystem.enums.Status;
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
public class StudentChecking extends Account{

    @Column(name="secret_key")
    private String secretKey;

    private BigDecimal balance;

    @Column(name="creation_date")
    private LocalDateTime creationDate;

    private Status status = Status.ACTIVE;

    public StudentChecking(BigDecimal penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey, BigDecimal balance) {
        super(penaltyFee, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        this.balance = balance;
    }
}
