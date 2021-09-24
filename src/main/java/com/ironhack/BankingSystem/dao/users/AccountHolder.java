package com.ironhack.BankingSystem.dao.users;

import com.ironhack.BankingSystem.dao.accounts.*;
import com.ironhack.BankingSystem.utils.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountHolder extends User{

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="address",column=@Column(name="primary_address"))
    })
    private Address primaryAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="address",column=@Column(name="mailing_address"))
    })
    private Address mailingAddress;

    @OneToMany(mappedBy = "primaryOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Account> primaryAccountList;

    @OneToMany(mappedBy = "secondaryOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Account> secondaryAccountList;
}
