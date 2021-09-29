Banking System API

This project was created to fullfil REST API capabilities of:
- Check account balance by an Account Holder
- Update balance due to interest rate and penalty fees automatically
- Make transactions between account A and B
- Make transactions by Third Parties.

How to use:

1. Create a database called "bankingsystem";

2. Start the program - the last line in the terminal will show an encrypted value ($passwordKey) of Admin password equivalent to "123456";

3. Run following queries to update your Database:

insert into users (id, password, username) values 
('1', '$passwordKey', 'admin');

insert into admin (id) values 
('1');

insert into roles (id, role, user_id) values 
('1', 'ADMIN', '1');

4. Now you can perform actions (at least those assigned to Admin role) with following authorisation data:
- login: admin
- password: 123456

Available routes (by Admin):
1. localhost:8080/admin/account/id/{id} - allows to get acount by id
2. localhost:8080/admin/account/{id}/balance - allows to get balance by id
3. localhost:8080/admin/account/{id}/balance - allows to update balance
4. localhost:8080/admin/checking-accounts - allows to get all checking accounts
5. localhost:8080/admin/checking-account/new/ - allows to create checking account
6. localhost:8080/admin/checking-account/{id} - allows to update checking account
7. localhost:8080/admin/savings-account/new - allows to create savings
8. localhost:8080/admin/student-checking-account/new - allows to create student checking
9. localhost:8080/admin/third-party-account/new - allows to create a Third Party
10. localhost:8080/admin/credit-card/new - allows to create credit card

Available routes (for Account Holders):
1. localhost:8080/my-accounts/{id}/balance - allows to get balance of an account awned by an Account Holder
2. localhost:8080/transfer - allows to send money by Account Holder

Available routes (for all Users):
1. localhost:8080/third-party/send-money - allows to send money
2. localhost:8080/third-party/receive-money - allows to receive money
