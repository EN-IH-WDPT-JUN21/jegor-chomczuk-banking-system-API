package com.ironhack.BankingSystem.controller.impm;

import com.ironhack.BankingSystem.controller.interfaces.IThirdPartyTransactionController;
import com.ironhack.BankingSystem.repository.ThirdPartyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThirdPartyTransactionController implements IThirdPartyTransactionController {

    @Autowired
    private ThirdPartyTransactionRepository thirdPartyTransactionRepository;
}
