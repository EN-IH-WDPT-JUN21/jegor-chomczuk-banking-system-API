package com.ironhack.BankingSystem.controller.impm;

import com.ironhack.BankingSystem.controller.interfaces.IStudentCheckingController;
import com.ironhack.BankingSystem.dao.StudentChecking;
import com.ironhack.BankingSystem.repository.StudentCheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class StudentCheckingController implements IStudentCheckingController {

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    //  The AccountHolders should be able to access their own accounts
    //  and only their accounts when passing the correct credentials
    //  using Basic Auth.

    //    Test endpoint: http://localhost:8080/student-checking-account-details/1
    @GetMapping("/student-checking-account-details/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<StudentChecking> getById(@PathVariable(name = "id") Long id){
        return studentCheckingRepository.findById(id);
    }

    //  Admins can create new accounts. When creating a new account
    //  they can create Checking, Savings, or CreditCard Accounts.

    //  Test endpoint: http://localhost:8080/new-student-checking-account
    @PostMapping("/new-student-checking-account")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentChecking store(@RequestBody @Valid StudentChecking studentChecking) {
        return studentCheckingRepository.save(studentChecking);
    }
}
