package com.ironhack.BankingSystem.dao.accounts;

import com.ironhack.BankingSystem.utils.Constants;
import com.ironhack.BankingSystem.dao.users.AccountHolder;
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
    private Long id;

    //  The penaltyFee for all accounts should be 40.
    private BigDecimal penaltyFee = Constants.PENALTY_FEE;

    @ManyToOne
    @JoinColumn(name = "primary_owner_id")
    private AccountHolder primaryOwner;

    @ManyToOne
    @JoinColumn(name = "secondary_owner_id")
    private AccountHolder secondaryOwner;

    //  Constructor
    public Account(BigDecimal penaltyFee, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        this.penaltyFee = penaltyFee;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
    }
}