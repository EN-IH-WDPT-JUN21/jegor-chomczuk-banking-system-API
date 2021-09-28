package com.ironhack.BankingSystem.service.impl;

import com.ironhack.BankingSystem.dao.User;
import com.ironhack.BankingSystem.repository.UserRepository;
import com.ironhack.BankingSystem.service.interfaces.IUserRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRetrieveService implements IUserRetrieveService {

    @Autowired
    private UserRepository userRepository;

    public User retrieveUser(Long id){
        return userRepository.getById(id);
    }
}
