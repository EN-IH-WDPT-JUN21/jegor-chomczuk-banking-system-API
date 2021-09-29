package com.ironhack.BankingSystem.controller.impl;

import com.ironhack.BankingSystem.controller.dto.CheckingDTO;
import com.ironhack.BankingSystem.controller.interfaces.IStudentCheckingController;
import com.ironhack.BankingSystem.dao.StudentChecking;
import com.ironhack.BankingSystem.service.interfaces.IStudentCheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentCheckingController implements IStudentCheckingController {

    @Autowired
    IStudentCheckingService studentAccountService;

    @PostMapping("/admin/student-checking-account/new")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentChecking createStudentChecking (@RequestBody @Valid CheckingDTO studentChecking) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return studentAccountService.createStudentChecking(studentChecking);
    }
}