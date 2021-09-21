
    create table account_holder (
       account_holder_id bigint not null auto_increment,
        name varchar(255),
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    create table admin (
       account_holder_id bigint not null auto_increment,
        name varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    create table checking (
       checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        monthly_maintenance_fee_currency varchar(255),
        monthly_maintenance_fee_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (checking_id)
    ) engine=InnoDB

    create table credit_card (
       credit_card_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        credit_limit_currency varchar(255),
        credit_limit_value decimal(19,2),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (credit_card_id)
    ) engine=InnoDB

    create table savings (
       savings_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (savings_id)
    ) engine=InnoDB

    create table student_checking (
       student_checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (student_checking_id)
    ) engine=InnoDB

    create table third_party (
       account_holder_id bigint not null auto_increment,
        name varchar(255),
        key varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    alter table checking 
       add constraint FK7eft4ijchaknf4n8v7ygd89oc 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table checking 
       add constraint FKos56augfo6m9nvquwt5xpdpv2 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FK64ykaeny0boc49vl9loffcir0 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FKg6qinxhdaj4f13ktfd5rj0w5r 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKjh4kjg6o822t3atskxa8bilep 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKe0wd1n8kopkrm3iohar81a3et 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKt73r1lo5un9krqna2rhvgmw0k 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKpwcy1lllfwcdv8uk45i2f1r9w 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    create table account_holder (
       account_holder_id bigint not null auto_increment,
        name varchar(255),
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    create table admin (
       account_holder_id bigint not null auto_increment,
        name varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    create table checking (
       checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        monthly_maintenance_fee_currency varchar(255),
        monthly_maintenance_fee_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (checking_id)
    ) engine=InnoDB

    create table credit_card (
       credit_card_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        credit_limit_currency varchar(255),
        credit_limit_value decimal(19,2),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (credit_card_id)
    ) engine=InnoDB

    create table savings (
       savings_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (savings_id)
    ) engine=InnoDB

    create table student_checking (
       student_checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (student_checking_id)
    ) engine=InnoDB

    create table third_party (
       account_holder_id bigint not null auto_increment,
        name varchar(255),
        key varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    alter table checking 
       add constraint FK7eft4ijchaknf4n8v7ygd89oc 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table checking 
       add constraint FKos56augfo6m9nvquwt5xpdpv2 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FK64ykaeny0boc49vl9loffcir0 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FKg6qinxhdaj4f13ktfd5rj0w5r 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKjh4kjg6o822t3atskxa8bilep 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKe0wd1n8kopkrm3iohar81a3et 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKt73r1lo5un9krqna2rhvgmw0k 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKpwcy1lllfwcdv8uk45i2f1r9w 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    create table account_holder (
       account_holder_id bigint not null auto_increment,
        name varchar(255),
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    create table admin (
       account_holder_id bigint not null auto_increment,
        name varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    create table checking (
       checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        monthly_maintenance_fee_currency varchar(255),
        monthly_maintenance_fee_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (checking_id)
    ) engine=InnoDB

    create table credit_card (
       credit_card_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        credit_limit_currency varchar(255),
        credit_limit_value decimal(19,2),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (credit_card_id)
    ) engine=InnoDB

    create table savings (
       savings_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (savings_id)
    ) engine=InnoDB

    create table student_checking (
       student_checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (student_checking_id)
    ) engine=InnoDB

    create table third_party (
       account_holder_id bigint not null auto_increment,
        name varchar(255),
        key varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    alter table checking 
       add constraint FK7eft4ijchaknf4n8v7ygd89oc 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table checking 
       add constraint FKos56augfo6m9nvquwt5xpdpv2 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FK64ykaeny0boc49vl9loffcir0 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FKg6qinxhdaj4f13ktfd5rj0w5r 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKjh4kjg6o822t3atskxa8bilep 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKe0wd1n8kopkrm3iohar81a3et 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKt73r1lo5un9krqna2rhvgmw0k 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKpwcy1lllfwcdv8uk45i2f1r9w 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    create table account_holder (
       account_holder_id bigint not null auto_increment,
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    create table admin (
       admin_id bigint not null auto_increment,
        name varchar(255),
        primary key (admin_id)
    ) engine=InnoDB

    create table checking (
       checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        monthly_maintenance_fee_currency varchar(255),
        monthly_maintenance_fee_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (checking_id)
    ) engine=InnoDB

    create table credit_card (
       credit_card_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        credit_limit_currency varchar(255),
        credit_limit_value decimal(19,2),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (credit_card_id)
    ) engine=InnoDB

    create table savings (
       savings_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (savings_id)
    ) engine=InnoDB

    create table student_checking (
       student_checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (student_checking_id)
    ) engine=InnoDB

    create table third_party (
       id bigint not null auto_increment,
        key varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table checking 
       add constraint FK7eft4ijchaknf4n8v7ygd89oc 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table checking 
       add constraint FKos56augfo6m9nvquwt5xpdpv2 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FK64ykaeny0boc49vl9loffcir0 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FKg6qinxhdaj4f13ktfd5rj0w5r 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKjh4kjg6o822t3atskxa8bilep 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKe0wd1n8kopkrm3iohar81a3et 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKt73r1lo5un9krqna2rhvgmw0k 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKpwcy1lllfwcdv8uk45i2f1r9w 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    create table account_holder (
       account_holder_id bigint not null auto_increment,
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    create table admin (
       admin_id bigint not null auto_increment,
        name varchar(255),
        primary key (admin_id)
    ) engine=InnoDB

    create table checking (
       checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        monthly_maintenance_fee_currency varchar(255),
        monthly_maintenance_fee_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (checking_id)
    ) engine=InnoDB

    create table credit_card (
       credit_card_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        credit_limit_currency varchar(255),
        credit_limit_value decimal(19,2),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (credit_card_id)
    ) engine=InnoDB

    create table savings (
       savings_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (savings_id)
    ) engine=InnoDB

    create table student_checking (
       student_checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (student_checking_id)
    ) engine=InnoDB

    create table third_party (
       id bigint not null auto_increment,
        key varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table checking 
       add constraint FK7eft4ijchaknf4n8v7ygd89oc 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table checking 
       add constraint FKos56augfo6m9nvquwt5xpdpv2 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FK64ykaeny0boc49vl9loffcir0 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FKg6qinxhdaj4f13ktfd5rj0w5r 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKjh4kjg6o822t3atskxa8bilep 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKe0wd1n8kopkrm3iohar81a3et 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKt73r1lo5un9krqna2rhvgmw0k 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKpwcy1lllfwcdv8uk45i2f1r9w 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    create table account_holder (
       account_holder_id bigint not null auto_increment,
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    create table admin (
       admin_id bigint not null auto_increment,
        name varchar(255),
        primary key (admin_id)
    ) engine=InnoDB

    create table checking (
       checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        monthly_maintenance_fee_currency varchar(255),
        monthly_maintenance_fee_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (checking_id)
    ) engine=InnoDB

    create table credit_card (
       credit_card_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        credit_limit_currency varchar(255),
        credit_limit_value decimal(19,2),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (credit_card_id)
    ) engine=InnoDB

    create table savings (
       savings_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (savings_id)
    ) engine=InnoDB

    create table student_checking (
       student_checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (student_checking_id)
    ) engine=InnoDB

    create table third_party (
       id bigint not null auto_increment,
        key varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table checking 
       add constraint FK7eft4ijchaknf4n8v7ygd89oc 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table checking 
       add constraint FKos56augfo6m9nvquwt5xpdpv2 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FK64ykaeny0boc49vl9loffcir0 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FKg6qinxhdaj4f13ktfd5rj0w5r 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKjh4kjg6o822t3atskxa8bilep 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKe0wd1n8kopkrm3iohar81a3et 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKt73r1lo5un9krqna2rhvgmw0k 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKpwcy1lllfwcdv8uk45i2f1r9w 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    create table account_holder (
       account_holder_id bigint not null auto_increment,
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    create table admin (
       admin_id bigint not null auto_increment,
        name varchar(255),
        primary key (admin_id)
    ) engine=InnoDB

    create table checking (
       checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        monthly_maintenance_fee_currency varchar(255),
        monthly_maintenance_fee_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (checking_id)
    ) engine=InnoDB

    create table credit_card (
       credit_card_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        credit_limit_currency varchar(255),
        credit_limit_value decimal(19,2),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (credit_card_id)
    ) engine=InnoDB

    create table savings (
       savings_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (savings_id)
    ) engine=InnoDB

    create table student_checking (
       student_checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (student_checking_id)
    ) engine=InnoDB

    create table third_party (
       id bigint not null auto_increment,
        key varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table checking 
       add constraint FK7eft4ijchaknf4n8v7ygd89oc 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table checking 
       add constraint FKos56augfo6m9nvquwt5xpdpv2 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FK64ykaeny0boc49vl9loffcir0 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FKg6qinxhdaj4f13ktfd5rj0w5r 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKjh4kjg6o822t3atskxa8bilep 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKe0wd1n8kopkrm3iohar81a3et 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKt73r1lo5un9krqna2rhvgmw0k 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKpwcy1lllfwcdv8uk45i2f1r9w 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    create table account_holder (
       account_holder_id bigint not null auto_increment,
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    create table admin (
       admin_id bigint not null auto_increment,
        name varchar(255),
        primary key (admin_id)
    ) engine=InnoDB

    create table checking (
       checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        monthly_maintenance_fee_currency varchar(255),
        monthly_maintenance_fee_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (checking_id)
    ) engine=InnoDB

    create table credit_card (
       credit_card_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        credit_limit_currency varchar(255),
        credit_limit_value decimal(19,2),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (credit_card_id)
    ) engine=InnoDB

    create table savings (
       savings_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (savings_id)
    ) engine=InnoDB

    create table student_checking (
       student_checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (student_checking_id)
    ) engine=InnoDB

    create table third_party (
       id bigint not null auto_increment,
        key varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table checking 
       add constraint FK7eft4ijchaknf4n8v7ygd89oc 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table checking 
       add constraint FKos56augfo6m9nvquwt5xpdpv2 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FK64ykaeny0boc49vl9loffcir0 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FKg6qinxhdaj4f13ktfd5rj0w5r 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKjh4kjg6o822t3atskxa8bilep 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKe0wd1n8kopkrm3iohar81a3et 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKt73r1lo5un9krqna2rhvgmw0k 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKpwcy1lllfwcdv8uk45i2f1r9w 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    create table account_holder (
       account_holder_id bigint not null auto_increment,
        date_of_birth datetime(6),
        mailing_address varchar(255),
        primary_address varchar(255),
        primary key (account_holder_id)
    ) engine=InnoDB

    create table admin (
       admin_id bigint not null auto_increment,
        name varchar(255),
        primary key (admin_id)
    ) engine=InnoDB

    create table checking (
       checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        monthly_maintenance_fee_currency varchar(255),
        monthly_maintenance_fee_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (checking_id)
    ) engine=InnoDB

    create table credit_card (
       credit_card_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        credit_limit_currency varchar(255),
        credit_limit_value decimal(19,2),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (credit_card_id)
    ) engine=InnoDB

    create table savings (
       savings_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        interest_rate_currency varchar(255),
        interest_rate_value decimal(19,2),
        minimum_balance_currency varchar(255),
        minimum_balance_value decimal(19,2),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (savings_id)
    ) engine=InnoDB

    create table student_checking (
       student_checking_id bigint not null auto_increment,
        balance_currency varchar(255),
        balance_value decimal(19,2),
        creation_date datetime(6),
        penalty_fee_currency varchar(255),
        penalty_fee_value decimal(19,2),
        secret_key varchar(255),
        status integer,
        primary_owner_id bigint,
        secondary_owner_id bigint,
        primary key (student_checking_id)
    ) engine=InnoDB

    create table third_party (
       id bigint not null auto_increment,
        key varchar(255),
        primary key (id)
    ) engine=InnoDB

    alter table checking 
       add constraint FK7eft4ijchaknf4n8v7ygd89oc 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table checking 
       add constraint FKos56augfo6m9nvquwt5xpdpv2 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FK64ykaeny0boc49vl9loffcir0 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table credit_card 
       add constraint FKg6qinxhdaj4f13ktfd5rj0w5r 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKjh4kjg6o822t3atskxa8bilep 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table savings 
       add constraint FKe0wd1n8kopkrm3iohar81a3et 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKt73r1lo5un9krqna2rhvgmw0k 
       foreign key (primary_owner_id) 
       references account_holder (account_holder_id)

    alter table student_checking 
       add constraint FKpwcy1lllfwcdv8uk45i2f1r9w 
       foreign key (secondary_owner_id) 
       references account_holder (account_holder_id)
