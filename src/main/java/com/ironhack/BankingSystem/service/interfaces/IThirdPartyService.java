package com.ironhack.BankingSystem.service.interfaces;

import com.ironhack.BankingSystem.controller.dto.ThirdPartyTransactionDTO;
import com.ironhack.BankingSystem.dao.ThirdParty;

import java.util.List;

public interface IThirdPartyService {
    ThirdParty createThirdParty(ThirdParty thirdParty);
    void sendMoney(ThirdPartyTransactionDTO thirdPartyTransactionDTO);
    void receiveMoney(ThirdPartyTransactionDTO thirdPartyTransactionDTO);
}
