package com.ironhack.BankingSystem.dao;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Admin extends User{

    public Admin(@NotNull(message = "Username required") String username, @NotNull(message = "Password required") String password) {
        super(username, password);
        super.setRole("ADMIN");
    }

    public Admin() {
    }
}
