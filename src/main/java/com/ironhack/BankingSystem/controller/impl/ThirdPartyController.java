package com.ironhack.BankingSystem.controller.impl;

import com.ironhack.BankingSystem.controller.dto.ThirdPartyTransactionDTO;
import com.ironhack.BankingSystem.controller.interfaces.IThirdPartyController;
import com.ironhack.BankingSystem.dao.ThirdParty;
import com.ironhack.BankingSystem.service.interfaces.IThirdPartyService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import javax.validation.constraints.*;
import java.util.*;

@RestController
public class ThirdPartyController implements IThirdPartyController {

    @Autowired
    IThirdPartyService thirdPartyService;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/admin/third-party-account/new")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty createThirdParty(@RequestBody @Valid ThirdParty thirdParty) {
        return thirdPartyService.createThirdParty(thirdParty);
    }

    @PostMapping("/third-party/send-money")
    @ResponseStatus(HttpStatus.OK)
    public void sendMoney(@RequestHeader @NotNull String hashedKey, @RequestBody @Valid ThirdPartyTransactionDTO thirdPartyTransactionDTO) {
        thirdPartyTransactionDTO.setHashedKey(hashedKey);
        thirdPartyService.sendMoney(thirdPartyTransactionDTO);
    }

    @PostMapping("/third-party/receive-money")
    @ResponseStatus(HttpStatus.OK)
    public void receiveMoney(@RequestHeader @NotNull String hashedKey,@RequestBody @Valid ThirdPartyTransactionDTO thirdPartyTransactionDTO) {
        thirdPartyTransactionDTO.setHashedKey(hashedKey);
        thirdPartyService.receiveMoney(thirdPartyTransactionDTO);
    }
}