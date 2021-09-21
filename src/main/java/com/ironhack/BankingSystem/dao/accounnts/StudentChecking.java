package com.ironhack.BankingSystem.dao.accounnts;

import com.ironhack.BankingSystem.dao.money.Money;
import com.ironhack.BankingSystem.enums.Status;
import com.ironhack.BankingSystem.dao.users.AccountHolder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentChecking extends Account{

    @Column(name="secret_key")
    private String secretKey;

    @Column(name="penalty_fee")
    @AttributeOverrides({
            @AttributeOverride(name="value",column=@Column(name="penalty_fee_value")),
            @AttributeOverride(name="currency",column=@Column(name="penalty_fee_currency"))
    })
    private Money penaltyFee;

    @Column(name="creation_date")
    private Date creationDate;

    private Status status;

//    The penaltyFee for all accounts should be 40.
//    If any account drops below the minimumBalance, the penaltyFee should be deducted from the balance automatically
}
