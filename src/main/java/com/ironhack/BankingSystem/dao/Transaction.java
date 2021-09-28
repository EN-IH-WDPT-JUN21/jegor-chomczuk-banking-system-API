package com.ironhack.BankingSystem.dao;

import com.ironhack.BankingSystem.utils.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    private Money amount;

    public Transaction(Account senderAccount, Account recipientAccount, Money transactionAmount) {
    }
}
