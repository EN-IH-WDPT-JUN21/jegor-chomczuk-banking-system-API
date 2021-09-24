package com.ironhack.BankingSystem.dao.transaction;

import com.ironhack.BankingSystem.dao.accounts.Account;
import com.ironhack.BankingSystem.dao.users.AccountHolder;
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
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "account_holder_id")
    AccountHolder accountHolder;

    @Column(name="time_stamp")
    private LocalDateTime timeStamp;

    private Money amount;
}
