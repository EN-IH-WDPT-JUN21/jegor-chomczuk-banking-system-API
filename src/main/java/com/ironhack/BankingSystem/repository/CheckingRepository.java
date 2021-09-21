package com.ironhack.BankingSystem.repository;

import com.ironhack.BankingSystem.dao.accounnts.Checking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends JpaRepository<Checking, Long> {
}
