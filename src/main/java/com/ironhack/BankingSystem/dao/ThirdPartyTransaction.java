package com.ironhack.BankingSystem.dao;

import com.ironhack.BankingSystem.utils.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "third_party_transaction")
public class ThirdPartyTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "third_party_id")
    ThirdParty thirdParty;

    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;

    private Money amount;

    public ThirdPartyTransaction(Account account, ThirdParty thirdParty, Money usd) {
    }
}
