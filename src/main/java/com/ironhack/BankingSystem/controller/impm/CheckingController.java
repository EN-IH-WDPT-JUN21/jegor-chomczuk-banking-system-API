package com.ironhack.BankingSystem.controller.impm;

import com.ironhack.BankingSystem.controller.dto.CheckingDTO;
import com.ironhack.BankingSystem.controller.interfaces.ICheckingController;
import com.ironhack.BankingSystem.dao.Account;
import com.ironhack.BankingSystem.dao.Checking;
import com.ironhack.BankingSystem.repository.CheckingRepository;
import com.ironhack.BankingSystem.repository.StudentCheckingRepository;
import com.ironhack.BankingSystem.service.interfaces.ICheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class CheckingController implements ICheckingController {

    @Autowired
    private CheckingRepository checkingRepository;

    @Autowired
    private StudentCheckingRepository studentCheckingRepository;

    @Autowired
    private ICheckingService checkingService;

    @PostMapping("/admin/checking-account/new/")
    @ResponseStatus(HttpStatus.CREATED)
    public Account createChecking(@RequestBody @Valid CheckingDTO checkingDTO) {

        return checkingService.createCheckingAccount(checkingDTO);
    }

    @Override
    public Optional<Checking> getById(Long id) {
        return Optional.empty();
    }


//    //  The AccountHolders should be able to access their own accounts
//    //  and only their accounts when passing the correct credentials
//    //  using Basic Auth.
//
//    //  Test endpoint: http://localhost:8080/checking-account-details/1
//    @GetMapping("/checking-account-details/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Optional<Checking> getById(@PathVariable(name = "id") Long id){
//        return checkingRepository.findById(id);
//    }
//
//    //  Admins can create new accounts. When creating a new account
//    //  they can create Checking, Savings, or CreditCard Accounts.
//
//    //  When creating a new Checking account, if the primaryOwner
//    //  is less than 24, a StudentChecking account should be created
//    //  otherwise a regular Checking Account should be created.
//
//    //  Test endpoint: http://localhost:8080/new-checking-account
//    @PostMapping("/new-checking-account")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Checking store(@RequestBody @Valid Checking checking) {
//        //  Extracting AH DOB
//        Date accountHolderDateOfBirth = checking.getPrimaryOwner().getDateOfBirth();
//        //  Converting Date DOB to Instant
//        Instant instantFromDate = accountHolderDateOfBirth.toInstant();
//        // Checking AH age in years
//        long accountHolderAgeInYears = ChronoUnit.YEARS.between(instantFromDate, LocalDate.now(ZoneId.of("Europe/Madrid")));
//
//        if (accountHolderAgeInYears < 24) {
//            return studentCheckingRepository.save(checking);
//        } else {
//            return checkingRepository.save(checking);
//        }
//    }
}
