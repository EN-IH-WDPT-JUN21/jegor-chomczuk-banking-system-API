package com.ironhack.BankingSystem.dao.users;

//import com.ironhack.BankingSystem.dao.accounnts.Savings;
import com.ironhack.BankingSystem.dao.accounnts.*;
import com.ironhack.BankingSystem.dao.address.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long account_holder_id;

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

//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(mappedBy = "primaryOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Account> primaryAccountList;
//
//    @LazyCollection(LazyCollectionOption.FALSE)
//    @OneToMany(mappedBy = "secondaryOwner", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Account> secondaryAccountList;
}
