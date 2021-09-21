package com.ironhack.BankingSystem.repository;

import com.ironhack.BankingSystem.dao.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
}