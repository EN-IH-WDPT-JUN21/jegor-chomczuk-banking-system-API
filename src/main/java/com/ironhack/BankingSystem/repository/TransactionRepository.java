package com.ironhack.BankingSystem.repository;

import com.ironhack.BankingSystem.dao.Account;
import com.ironhack.BankingSystem.dao.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findTransactionBySenderAndTimeStampBetween(Account sender, LocalDateTime secondAgo, LocalDateTime now);

    @Query(value = "SELECT SUM(t.amount) FROM bankingsys.transactions t WHERE sender_account_id = :id AND  t.time_stamp < date_sub(now(), interval 24 HOUR) GROUP BY DATE(t.time_stamp) ORDER BY 1 DESC LIMIT 1", nativeQuery = true)
    Optional<BigDecimal> getMaxByDay(@Param("id") Long id);

    @Query(value = "SELECT SUM(t.amount) FROM bankingsys.transactions t WHERE sender_account_id = :id AND t.time_stamp > date_sub(now(), interval 24 HOUR) LIMIT 1", nativeQuery = true)
    Optional<BigDecimal> getSumLastTransactions(@Param("id") Long id);
}
