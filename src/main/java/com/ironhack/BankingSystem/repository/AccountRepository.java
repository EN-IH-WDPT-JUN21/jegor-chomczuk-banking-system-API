package com.ironhack.BankingSystem.repository;

import com.ironhack.BankingSystem.dao.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountHolderName(String name);
    Optional<Account> findBySecondaryAccountHolderName(String name);
    List<Account> findAccountsByAccountHolderId(Long id);
    List<Account> findAccountsBySecondaryAccountHolderId(Long id);
}
