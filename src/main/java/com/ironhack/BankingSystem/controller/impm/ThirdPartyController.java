package com.ironhack.BankingSystem.controller.impm;

import com.ironhack.BankingSystem.controller.interfaces.IThirdPartyController;
import com.ironhack.BankingSystem.repository.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdPartyController implements IThirdPartyController {

    @Autowired
    private ThirdPartyRepository thirdPartyRepository;
}
