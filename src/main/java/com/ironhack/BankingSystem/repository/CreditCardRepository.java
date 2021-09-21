package com.ironhack.BankingSystem.repository;

import com.ironhack.BankingSystem.dao.accounnts.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
}
