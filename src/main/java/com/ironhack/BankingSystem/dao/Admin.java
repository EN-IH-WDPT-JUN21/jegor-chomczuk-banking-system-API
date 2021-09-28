package com.ironhack.BankingSystem.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Admin extends User{
    public Admin(@NotNull(message = "Username required") String username, @NotNull(message = "Password required") String password) {
        super(username, password);
        super.setRole("ADMIN");
    }
}
