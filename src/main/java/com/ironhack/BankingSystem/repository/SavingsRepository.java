package com.ironhack.BankingSystem.repository;

import com.ironhack.BankingSystem.dao.accounnts.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends JpaRepository<Savings, Long> {
}
