package com.ironhack.BankingSystem.controller.interfaces;

import com.ironhack.BankingSystem.controller.dto.ThirdPartyTransactionDTO;
import com.ironhack.BankingSystem.dao.ThirdParty;

import java.util.List;

public interface IThirdPartyController {
    ThirdParty createThirdParty(ThirdParty thirdParty);
    void sendMoney (String hashedKey, ThirdPartyTransactionDTO thirdPartyTransactionDTO);
    void receiveMoney(String hashedKey, ThirdPartyTransactionDTO thirdPartyTransactionDTO);
}
