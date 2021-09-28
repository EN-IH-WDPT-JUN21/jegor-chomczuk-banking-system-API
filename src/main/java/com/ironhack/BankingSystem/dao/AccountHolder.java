package com.ironhack.BankingSystem.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.BankingSystem.utils.Address;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.*;
import javax.validation.constraints.*;
import java.time.*;
import java.util.*;

@Entity
@Setter
@Getter
@Table(name = "account_holders")
@PrimaryKeyJoinColumn(name = "id")
public class AccountHolder extends User {

    private LocalDateTime dateOfBirth;

    private String name;

    @Valid
    @Embedded
    private Address primaryAddress;

    @Valid
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country", column = @Column(name = "mail_address_country")),
            @AttributeOverride(name = "city", column = @Column(name = "mail_address_city")),
            @AttributeOverride(name = "streetName", column = @Column(name = "mail_address_street")),
            @AttributeOverride(name = "number", column = @Column(name = "mail_address_number")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "mail_address_zip_code"))
    })
    private Address mailingAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "accountHolder")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Account> primaryAccounts;

    @JsonIgnore
    @OneToMany(mappedBy = "secondaryAccountHolder")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Account> secondaryAccounts;

    public AccountHolder() {
        super.setRole("ACCOUNT_HOLDER");
    }

    public AccountHolder(String username, String password, String name, LocalDateTime dateOfBirth, Address address) {
        super(username, password);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = address;
        this.name = name;
        super.setRole("ACCOUNT_HOLDER");
    }

    public AccountHolder(String username, String password, String name, LocalDateTime dateOfBirth, Address primaryAddress, @Valid Address mailingAddress) {
        super(username, password);
        this.dateOfBirth = dateOfBirth;
        this.primaryAddress = primaryAddress;
        this.mailingAddress = mailingAddress;
        this.name = name;
        super.setRole("ACCOUNT_HOLDER");
    }
}