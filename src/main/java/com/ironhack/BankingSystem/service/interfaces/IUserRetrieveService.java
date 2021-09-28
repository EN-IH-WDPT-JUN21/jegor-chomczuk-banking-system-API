package com.ironhack.BankingSystem.service.interfaces;

import com.ironhack.BankingSystem.dao.User;

public interface IUserRetrieveService {
    User retrieveUser(Long id);
}
