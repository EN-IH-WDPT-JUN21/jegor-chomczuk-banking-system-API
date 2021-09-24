
    create table account (
       id bigint not null auto_increment,
        balance decimal(19,2),
        penalty_fee decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table account_holder (
       id bigint not null auto_increment,
        password varchar(255),
        user_name varchar(255),
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table admin (
       id bigint not null auto_increment,
        password varchar(255),
        user_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table checking (
       creation_date datetime(6),
        minimum_balance decimal(19,2),
        monthly_maintenance_fee decimal(19,2),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table credit_card (
       credit_limit decimal(19,2),
        interest_rate decimal(19,2),
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table savings (
       creation_date datetime(6),
        interest_rate decimal(19,2),
        minimum_balance decimal(19,2),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table student_checking (
       creation_date datetime(6),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table third_party_transaction (
       id bigint not null auto_increment,
        amount decimal(19,2),
        currency varchar(255),
        time_stamp datetime(6),
        account_id bigint,
        third_party_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table third_party (
       id bigint not null auto_increment,
        hashed_key varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table transaction (
       id bigint not null auto_increment,
        amount decimal(19,2),
        currency varchar(255),
        time_stamp datetime(6),
        account_id bigint,
        account_holder_id bigint,
        primary key (id)
    ) engine=InnoDB

    alter table account 
       add constraint FKeb4hr0wmc9ab52ulodr1dcoq2 
       foreign key (primary_owner_id) 
       references account_holder (id)

    alter table account 
       add constraint FKa4ukcqpfubnnuxjp9sqwfvj1c 
       foreign key (secondary_owner_id) 
       references account_holder (id)

    alter table checking 
       add constraint FK4pww71v1myyn2iai6qm84t29o 
       foreign key (id) 
       references account (id)

    alter table credit_card 
       add constraint FK5nn2ykrc28pst4v0axopldeqv 
       foreign key (id) 
       references account (id)

    alter table savings 
       add constraint FKs02t0s57xrunyqosm96vrttin 
       foreign key (id) 
       references account (id)

    alter table student_checking 
       add constraint FKcw2ja1qwe1e6xhuj4e1o9jvy6 
       foreign key (id) 
       references account (id)

    alter table third_party_transaction 
       add constraint FKe28y5qlshns7j4pf5sp70n6t8 
       foreign key (account_id) 
       references account (id)

    alter table third_party_transaction 
       add constraint FKjldacw60ivde7a2x85atdp1ms 
       foreign key (third_party_id) 
       references third_party (id)

    alter table transaction 
       add constraint FK6g20fcr3bhr6bihgy24rq1r1b 
       foreign key (account_id) 
       references account (id)

    alter table transaction 
       add constraint FKm7i4ms72y7b44q8ymvcul6ke6 
       foreign key (account_holder_id) 
       references account_holder (id)

    create table account (
       id bigint not null auto_increment,
        balance decimal(19,2),
        penalty_fee decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table account_holder (
       id bigint not null auto_increment,
        password varchar(255),
        user_name varchar(255),
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table admin (
       id bigint not null auto_increment,
        password varchar(255),
        user_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table checking (
       creation_date datetime(6),
        minimum_balance decimal(19,2),
        monthly_maintenance_fee decimal(19,2),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table credit_card (
       credit_limit decimal(19,2),
        interest_rate decimal(19,2),
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table savings (
       creation_date datetime(6),
        interest_rate decimal(19,2),
        minimum_balance decimal(19,2),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table student_checking (
       creation_date datetime(6),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table third_party_transaction (
       id bigint not null auto_increment,
        amount decimal(19,2),
        currency varchar(255),
        time_stamp datetime(6),
        account_id bigint,
        third_party_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table third_party (
       id bigint not null auto_increment,
        hashed_key varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table transaction (
       id bigint not null auto_increment,
        amount decimal(19,2),
        currency varchar(255),
        time_stamp datetime(6),
        account_id bigint,
        account_holder_id bigint,
        primary key (id)
    ) engine=InnoDB

    alter table account 
       add constraint FKeb4hr0wmc9ab52ulodr1dcoq2 
       foreign key (primary_owner_id) 
       references account_holder (id)

    alter table account 
       add constraint FKa4ukcqpfubnnuxjp9sqwfvj1c 
       foreign key (secondary_owner_id) 
       references account_holder (id)

    alter table checking 
       add constraint FK4pww71v1myyn2iai6qm84t29o 
       foreign key (id) 
       references account (id)

    alter table credit_card 
       add constraint FK5nn2ykrc28pst4v0axopldeqv 
       foreign key (id) 
       references account (id)

    alter table savings 
       add constraint FKs02t0s57xrunyqosm96vrttin 
       foreign key (id) 
       references account (id)

    alter table student_checking 
       add constraint FKcw2ja1qwe1e6xhuj4e1o9jvy6 
       foreign key (id) 
       references account (id)

    alter table third_party_transaction 
       add constraint FKe28y5qlshns7j4pf5sp70n6t8 
       foreign key (account_id) 
       references account (id)

    alter table third_party_transaction 
       add constraint FKjldacw60ivde7a2x85atdp1ms 
       foreign key (third_party_id) 
       references third_party (id)

    alter table transaction 
       add constraint FK6g20fcr3bhr6bihgy24rq1r1b 
       foreign key (account_id) 
       references account (id)

    alter table transaction 
       add constraint FKm7i4ms72y7b44q8ymvcul6ke6 
       foreign key (account_holder_id) 
       references account_holder (id)

    create table account (
       id bigint not null auto_increment,
        balance decimal(19,2),
        penalty_fee decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table account_holder (
       id bigint not null auto_increment,
        password varchar(255),
        user_name varchar(255),
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table admin (
       id bigint not null auto_increment,
        password varchar(255),
        user_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table checking (
       creation_date datetime(6),
        minimum_balance decimal(19,2),
        monthly_maintenance_fee decimal(19,2),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table credit_card (
       credit_limit decimal(19,2),
        interest_rate decimal(19,2),
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table savings (
       creation_date datetime(6),
        interest_rate decimal(19,2),
        minimum_balance decimal(19,2),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table student_checking (
       creation_date datetime(6),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table third_party_transaction (
       id bigint not null auto_increment,
        amount decimal(19,2),
        currency varchar(255),
        time_stamp datetime(6),
        account_id bigint,
        third_party_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table third_party (
       id bigint not null auto_increment,
        hashed_key varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table transaction (
       id bigint not null auto_increment,
        amount decimal(19,2),
        currency varchar(255),
        time_stamp datetime(6),
        account_id bigint,
        account_holder_id bigint,
        primary key (id)
    ) engine=InnoDB

    alter table account 
       add constraint FKeb4hr0wmc9ab52ulodr1dcoq2 
       foreign key (primary_owner_id) 
       references account_holder (id)

    alter table account 
       add constraint FKa4ukcqpfubnnuxjp9sqwfvj1c 
       foreign key (secondary_owner_id) 
       references account_holder (id)

    alter table checking 
       add constraint FK4pww71v1myyn2iai6qm84t29o 
       foreign key (id) 
       references account (id)

    alter table credit_card 
       add constraint FK5nn2ykrc28pst4v0axopldeqv 
       foreign key (id) 
       references account (id)

    alter table savings 
       add constraint FKs02t0s57xrunyqosm96vrttin 
       foreign key (id) 
       references account (id)

    alter table student_checking 
       add constraint FKcw2ja1qwe1e6xhuj4e1o9jvy6 
       foreign key (id) 
       references account (id)

    alter table third_party_transaction 
       add constraint FKe28y5qlshns7j4pf5sp70n6t8 
       foreign key (account_id) 
       references account (id)

    alter table third_party_transaction 
       add constraint FKjldacw60ivde7a2x85atdp1ms 
       foreign key (third_party_id) 
       references third_party (id)

    alter table transaction 
       add constraint FK6g20fcr3bhr6bihgy24rq1r1b 
       foreign key (account_id) 
       references account (id)

    alter table transaction 
       add constraint FKm7i4ms72y7b44q8ymvcul6ke6 
       foreign key (account_holder_id) 
       references account_holder (id)

    create table account (
       id bigint not null auto_increment,
        penalty_fee decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table account_holder (
       id bigint not null auto_increment,
        password varchar(255),
        user_name varchar(255),
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table admin (
       id bigint not null auto_increment,
        password varchar(255),
        user_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table checking (
       balance decimal(19,2),
        creation_date datetime(6),
        minimum_balance decimal(19,2),
        monthly_maintenance_fee decimal(19,2),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table credit_card (
       balance decimal(19,2),
        credit_limit decimal(19,2),
        interest_rate decimal(19,2),
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table savings (
       balance decimal(19,2),
        creation_date datetime(6),
        interest_rate decimal(19,2),
        minimum_balance decimal(19,2),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table student_checking (
       balance decimal(19,2),
        creation_date datetime(6),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table third_party_transaction (
       id bigint not null auto_increment,
        amount decimal(19,2),
        currency varchar(255),
        time_stamp datetime(6),
        account_id bigint,
        third_party_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table third_party (
       id bigint not null auto_increment,
        hashed_key varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table transaction (
       id bigint not null auto_increment,
        amount decimal(19,2),
        currency varchar(255),
        time_stamp datetime(6),
        account_id bigint,
        account_holder_id bigint,
        primary key (id)
    ) engine=InnoDB

    alter table account 
       add constraint FKeb4hr0wmc9ab52ulodr1dcoq2 
       foreign key (primary_owner_id) 
       references account_holder (id)

    alter table account 
       add constraint FKa4ukcqpfubnnuxjp9sqwfvj1c 
       foreign key (secondary_owner_id) 
       references account_holder (id)

    alter table checking 
       add constraint FK4pww71v1myyn2iai6qm84t29o 
       foreign key (id) 
       references account (id)

    alter table credit_card 
       add constraint FK5nn2ykrc28pst4v0axopldeqv 
       foreign key (id) 
       references account (id)

    alter table savings 
       add constraint FKs02t0s57xrunyqosm96vrttin 
       foreign key (id) 
       references account (id)

    alter table student_checking 
       add constraint FKcw2ja1qwe1e6xhuj4e1o9jvy6 
       foreign key (id) 
       references account (id)

    alter table third_party_transaction 
       add constraint FKe28y5qlshns7j4pf5sp70n6t8 
       foreign key (account_id) 
       references account (id)

    alter table third_party_transaction 
       add constraint FKjldacw60ivde7a2x85atdp1ms 
       foreign key (third_party_id) 
       references third_party (id)

    alter table transaction 
       add constraint FK6g20fcr3bhr6bihgy24rq1r1b 
       foreign key (account_id) 
       references account (id)

    alter table transaction 
       add constraint FKm7i4ms72y7b44q8ymvcul6ke6 
       foreign key (account_holder_id) 
       references account_holder (id)

    create table account (
       id bigint not null auto_increment,
        penalty_fee decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table account_holder (
       id bigint not null auto_increment,
        password varchar(255),
        user_name varchar(255),
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table admin (
       id bigint not null auto_increment,
        password varchar(255),
        user_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table checking (
       balance decimal(19,2),
        creation_date datetime(6),
        minimum_balance decimal(19,2),
        monthly_maintenance_fee decimal(19,2),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table credit_card (
       balance decimal(19,2),
        credit_limit decimal(19,2),
        interest_rate decimal(19,2),
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table savings (
       balance decimal(19,2),
        creation_date datetime(6),
        interest_rate decimal(19,2),
        minimum_balance decimal(19,2),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table student_checking (
       balance decimal(19,2),
        creation_date datetime(6),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table third_party_transaction (
       id bigint not null auto_increment,
        amount decimal(19,2),
        currency varchar(255),
        time_stamp datetime(6),
        account_id bigint,
        third_party_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table third_party (
       id bigint not null auto_increment,
        hashed_key varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table transaction (
       id bigint not null auto_increment,
        amount decimal(19,2),
        currency varchar(255),
        time_stamp datetime(6),
        account_id bigint,
        account_holder_id bigint,
        primary key (id)
    ) engine=InnoDB

    alter table account 
       add constraint FKeb4hr0wmc9ab52ulodr1dcoq2 
       foreign key (primary_owner_id) 
       references account_holder (id)

    alter table account 
       add constraint FKa4ukcqpfubnnuxjp9sqwfvj1c 
       foreign key (secondary_owner_id) 
       references account_holder (id)

    alter table checking 
       add constraint FK4pww71v1myyn2iai6qm84t29o 
       foreign key (id) 
       references account (id)

    alter table credit_card 
       add constraint FK5nn2ykrc28pst4v0axopldeqv 
       foreign key (id) 
       references account (id)

    alter table savings 
       add constraint FKs02t0s57xrunyqosm96vrttin 
       foreign key (id) 
       references account (id)

    alter table student_checking 
       add constraint FKcw2ja1qwe1e6xhuj4e1o9jvy6 
       foreign key (id) 
       references account (id)

    alter table third_party_transaction 
       add constraint FKe28y5qlshns7j4pf5sp70n6t8 
       foreign key (account_id) 
       references account (id)

    alter table third_party_transaction 
       add constraint FKjldacw60ivde7a2x85atdp1ms 
       foreign key (third_party_id) 
       references third_party (id)

    alter table transaction 
       add constraint FK6g20fcr3bhr6bihgy24rq1r1b 
       foreign key (account_id) 
       references account (id)

    alter table transaction 
       add constraint FKm7i4ms72y7b44q8ymvcul6ke6 
       foreign key (account_holder_id) 
       references account_holder (id)

    create table account (
       id bigint not null auto_increment,
        penalty_fee decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table account_holder (
       id bigint not null auto_increment,
        password varchar(255),
        user_name varchar(255),
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table admin (
       id bigint not null auto_increment,
        password varchar(255),
        user_name varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table checking (
       balance decimal(19,2),
        creation_date datetime(6),
        minimum_balance decimal(19,2),
        monthly_maintenance_fee decimal(19,2),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table credit_card (
       balance decimal(19,2),
        creation_date datetime(6),
        credit_limit decimal(19,2),
        interest_rate decimal(19,2),
        last_interest_add_date datetime(6),
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table savings (
       balance decimal(19,2),
        creation_date datetime(6),
        interest_rate decimal(19,2),
        last_interest_add_date datetime(6),
        minimum_balance decimal(19,2),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table student_checking (
       balance decimal(19,2),
        creation_date datetime(6),
        secret_key varchar(255),
        status integer,
        id bigint not null,
        primary key (id)
    ) engine=InnoDB

    create table third_party_transaction (
       id bigint not null auto_increment,
        amount decimal(19,2),
        currency varchar(255),
        time_stamp datetime(6),
        account_id bigint,
        third_party_id bigint,
        primary key (id)
    ) engine=InnoDB

    create table third_party (
       id bigint not null auto_increment,
        hashed_key varchar(255),
        primary key (id)
    ) engine=InnoDB

    create table transaction (
       id bigint not null auto_increment,
        amount decimal(19,2),
        currency varchar(255),
        time_stamp datetime(6),
        account_id bigint,
        account_holder_id bigint,
        primary key (id)
    ) engine=InnoDB

    alter table account 
       add constraint FKeb4hr0wmc9ab52ulodr1dcoq2 
       foreign key (primary_owner_id) 
       references account_holder (id)

    alter table account 
       add constraint FKa4ukcqpfubnnuxjp9sqwfvj1c 
       foreign key (secondary_owner_id) 
       references account_holder (id)

    alter table checking 
       add constraint FK4pww71v1myyn2iai6qm84t29o 
       foreign key (id) 
       references account (id)

    alter table credit_card 
       add constraint FK5nn2ykrc28pst4v0axopldeqv 
       foreign key (id) 
       references account (id)

    alter table savings 
       add constraint FKs02t0s57xrunyqosm96vrttin 
       foreign key (id) 
       references account (id)

    alter table student_checking 
       add constraint FKcw2ja1qwe1e6xhuj4e1o9jvy6 
       foreign key (id) 
       references account (id)

    alter table third_party_transaction 
       add constraint FKe28y5qlshns7j4pf5sp70n6t8 
       foreign key (account_id) 
       references account (id)

    alter table third_party_transaction 
       add constraint FKjldacw60ivde7a2x85atdp1ms 
       foreign key (third_party_id) 
       references third_party (id)

    alter table transaction 
       add constraint FK6g20fcr3bhr6bihgy24rq1r1b 
       foreign key (account_id) 
       references account (id)

    alter table transaction 
       add constraint FKm7i4ms72y7b44q8ymvcul6ke6 
       foreign key (account_holder_id) 
       references account_holder (id)
