package com.ironhack.BankingSystem.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThirdParty{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hashed_key")
    private String hashedKey;

    public ThirdParty(@NotNull(message = "Hashed key required") String hashedKey) {
        this.hashedKey = hashedKey;
    }
}
