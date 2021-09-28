package com.ironhack.BankingSystem.controller.impm;

import com.ironhack.BankingSystem.controller.interfaces.IAdminController;
import com.ironhack.BankingSystem.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController implements IAdminController {

    @Autowired
    private AdminRepository adminRepository;
}
