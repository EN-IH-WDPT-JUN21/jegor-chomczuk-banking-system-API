package com.ironhack.BankingSystem.dao;

import com.ironhack.BankingSystem.utils.Constants;
import com.ironhack.BankingSystem.utils.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "secret_key")
    private String secretKey;

    private Money balance;

    //  The penaltyFee for all accounts should be 40.
    private BigDecimal penaltyFee = Constants.PENALTY_FEE;

    @ManyToOne
    @JoinColumn(name = "primary_owner_id")
    private AccountHolder accountHolder;

    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    private AccountHolder secondaryAccountHolder;
}