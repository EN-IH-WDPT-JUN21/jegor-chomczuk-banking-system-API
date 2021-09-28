package com.ironhack.BankingSystem.service.impl;

import com.ironhack.BankingSystem.controller.dto.TransactionDTO;
import com.ironhack.BankingSystem.dao.*;
import com.ironhack.BankingSystem.interfaces.Freezable;
import com.ironhack.BankingSystem.interfaces.Penalizable;
import com.ironhack.BankingSystem.enums.Status;
import com.ironhack.BankingSystem.repository.CheckingRepository;
import com.ironhack.BankingSystem.repository.CreditCardRepository;
import com.ironhack.BankingSystem.repository.SavingsRepository;
import com.ironhack.BankingSystem.repository.StudentCheckingRepository;
import com.ironhack.BankingSystem.repository.TransactionRepository;
import com.ironhack.BankingSystem.utils.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class TransactionService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private SavingsRepository savingsRepository;

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public CreditCard applyInterestRate(CreditCard creditCard) {
        Long monthsBetween = ChronoUnit.MONTHS.between(creditCard.getLastInterestApplied(), LocalDateTime.now());
        if (monthsBetween > 0 && creditCard.getBalance().getAmount().compareTo(BigDecimal.ZERO) > 0) {
            creditCard.setBalance(
                    new Money(creditCard.getBalance().getAmount()
                            .multiply(new BigDecimal(monthsBetween))
                            .multiply(
                                    creditCard.getInterestRate()
                                            .divide(new BigDecimal("12")))));
            creditCard.setLastInterestApplied(LocalDateTime.now());
            creditCardRepository.save(creditCard);
        }
        return creditCard;
    }

    public Savings applyInterestRate(Savings savings) {
        Long yearsBetween = ChronoUnit.YEARS.between(savings.getLastInterestsApplied(), LocalDateTime.now());
        if (yearsBetween > 0 && savings.getBalance().getAmount().compareTo(savings.getMinimumBalance().getAmount()) > 0) {
            savings.setBalance(
                    new Money(savings.getBalance().getAmount()
                            .multiply(new BigDecimal(yearsBetween))
                            .multiply(
                                    savings.getInterestRate()
                            )));
            savings.setLastInterestsApplied(LocalDateTime.now());
            savingsRepository.save(savings);

        }
        return savings;
    }

    public Checking applyMonthlyFee(Checking checking) {
        Long monthBetween = ChronoUnit.MONTHS.between(checking.getLastMonthlyFeeApplied(), LocalDateTime.now());
        if (monthBetween > 0) {
            checking.setBalance(
                    new Money(checking.getBalance().getAmount()
                            .subtract(new BigDecimal(monthBetween))
                            .multiply(checking.getMonthlyMaintenanceFee().getAmount()
                            )));
            checking.setLastMonthlyFeeApplied(LocalDateTime.now());
            checkingRepository.save(checking);
        }
        return checking;
    }

    private void makeTransaction(TransactionDTO transactionDTO, Account senderAccount, Account recipientAccount) {
        senderAccount.setBalance(new Money(senderAccount.getBalance().getAmount().subtract(transactionDTO.getTransactionAmount().getAmount()), senderAccount.getBalance().getCurrency()));
        recipientAccount.setBalance(new Money(recipientAccount.getBalance().getAmount().add(transactionDTO.getTransactionAmount().getAmount()), recipientAccount.getBalance().getCurrency()));
        transactionRepository.save(new Transaction(senderAccount, recipientAccount, transactionDTO.getTransactionAmount()));
    }


    //Determines if the account given is making the transaction
    private boolean isSender(Account account, TransactionDTO transactionDTO) {
        return account.getAccountId().equals(transactionDTO.getSenderAccountId());
    }

    //This method only takes accounts that have Status and evaluates if there has been fraud
    public void checkFraud(Freezable senderAccount) {
        //Retrieves the last transaction made in the last second (if exists)
        if (transactionRepository.findTransactionBySenderAndTimeStampBetween((Account) senderAccount, LocalDateTime.now().minusSeconds(1), LocalDateTime.now()).isPresent()) {
            senderAccount.setStatus(Status.FROZEN);
            saveAccount((Account) senderAccount);
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Transaction rejected: Your account is now frozen due to a potential fraud detected");
        }

        if (transactionRepository.getMaxByDay(senderAccount.getAccountId()).isPresent() && transactionRepository.getSumLastTransactions(senderAccount.getAccountId()).isPresent()) {

            //Compares the max sum of transactions in any day to the sum of the transactions in the last 24 hours
            BigDecimal getMaxByDay = transactionRepository.getMaxByDay(senderAccount.getAccountId()).get().multiply(new BigDecimal("1.5"));
            BigDecimal getLastDay = transactionRepository.getSumLastTransactions(senderAccount.getAccountId()).get();

            if (getMaxByDay.compareTo(getLastDay) < 0) {

                senderAccount.setStatus(Status.FROZEN);
                saveAccount((Account) senderAccount);
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Transaction rejected: Your account is now frozen due to a potential fraud detected");
            }
        }
    }

    //Overridden method that applies only to credit cards. It only evaluates if there was a transaction in the last second
    private void checkFraud(CreditCard creditCard) {
        if (transactionRepository.findTransactionBySenderAndTimeStampBetween((Account) creditCard, LocalDateTime.now().minusSeconds(1), LocalDateTime.now()).isPresent()) {
            saveAccount(creditCard);
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Transaction rejected: You cannot transfer money now due to a potential fraud detected");

        }
    }

    public boolean enoughFunds(Account account, BigDecimal amount) {
        return account.getBalance().getAmount().subtract(amount).compareTo(BigDecimal.ZERO) > 0;
    }

    public void checkStatus(Freezable savingsAccount) {
        if (savingsAccount.getStatus().equals(Status.FROZEN)) {
            saveAccount((Account) savingsAccount);
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Account " + savingsAccount.getAccountId() + " is suspended");
        }
    }

    private boolean dropsBelowMinimumBalance(Penalizable penalizable, BigDecimal amount) {
        return penalizable.getMinimumBalance().getAmount().compareTo(penalizable.getBalance().getAmount().subtract(amount)) > 0;
    }

    private void checkBalanceAndApplyExtraFees(Penalizable account, TransactionDTO transactionDTO) {
        if (account.getAccountId().equals(transactionDTO.getSenderAccountId())) {
            if (dropsBelowMinimumBalance(account, transactionDTO.getTransactionAmount().getAmount())) {
                if (!enoughFunds((Account) account, transactionDTO.getTransactionAmount().getAmount())) {
                    saveAccount((Account) account);
                    throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Sorry, but the account you are trying to transfer funds from does not have enough funds to perform this transaction");
                } else {
                    applyPenaltyFee(account);
                }
            }
        }
    }

    public void checkBalanceAndApplyExtraFeesThirdParty(Penalizable account, BigDecimal amount) {
        if (dropsBelowMinimumBalance(account, amount)) {
            if (!enoughFunds((Account) account, amount)) {
                saveAccount((Account) account);
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Sorry, but the account you are trying to transfer funds from does not have enough funds to perform this transaction");
            } else {
                applyPenaltyFee(account);
            }
        }
    }

    private void saveAccount(Account account) {
        if (account instanceof Checking) {
            checkingRepository.save((Checking) account);
        } else if (account instanceof StudentChecking) {
            studentCheckingRepository.save((StudentChecking) account);
        } else if (account instanceof CreditCard) {
            creditCardRepository.save((CreditCard) account);
        } else if (account instanceof Savings) {
            savingsRepository.save((Savings) account);
        }
    }

    private void applyPenaltyFee(Penalizable account) {

    }

    private Account evaluateAccounts(Account account, TransactionDTO transactionDTO) {
        if (account instanceof Checking) {
            Checking checkingAccount = (Checking) account;
            checkStatus(checkingAccount);
            if (isSender(checkingAccount, transactionDTO)) {
                checkFraud(checkingAccount);
                if (!enoughFunds(checkingAccount, transactionDTO.getTransactionAmount().getAmount())) {
                    saveAndThrowException(checkingAccount);
                } else {
                    return checkingAccount;
                }
            }
            applyMonthlyFee(checkingAccount);
            checkBalanceAndApplyExtraFees(checkingAccount, transactionDTO);
            return checkingAccount;

        } else if (account instanceof StudentChecking) {
            StudentChecking studentCheckingAccount = (StudentChecking) account;
            checkStatus(studentCheckingAccount);
            if (isSender(studentCheckingAccount, transactionDTO)) {
                checkFraud(studentCheckingAccount);
                if (!enoughFunds(studentCheckingAccount, transactionDTO.getTransactionAmount().getAmount())) {
                    saveAndThrowException(studentCheckingAccount);
                } else {
                    return studentCheckingAccount;
                }
            } else {
                return studentCheckingAccount;
            }

        } else if (account instanceof CreditCard) {
            CreditCard creditCard = (CreditCard) account;
            applyInterestRate(creditCard);
            checkFraud(creditCard);


        } else if (account instanceof Savings) {
            Savings savingsAccount = (Savings) account;
            checkStatus(savingsAccount);
            applyInterestRate(savingsAccount);
            if (isSender(savingsAccount, transactionDTO)) {
                checkFraud(savingsAccount);
                if (!enoughFunds(savingsAccount, transactionDTO.getTransactionAmount().getAmount())) {
                    saveAndThrowException(savingsAccount);
                }
            }

        }
        return account;
    }

    private void saveAndThrowException(Account account) {
        saveAccount(account);
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Sorry, but the account you are trying to transfer funds from does not have enough funds to perform this transaction");
    }
}
