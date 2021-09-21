package com.ironhack.BankingSystem.repository;

import com.ironhack.BankingSystem.dao.users.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
