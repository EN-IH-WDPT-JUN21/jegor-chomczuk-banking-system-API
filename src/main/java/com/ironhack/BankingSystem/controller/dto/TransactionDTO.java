package com.ironhack.BankingSystem.controller.dto;

import com.ironhack.BankingSystem.utils.Money;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Currency;

@Setter
@Getter
public class TransactionDTO {

    private Long senderAccountId;
    private Long recipientAccountId;
    private String recipientName;
    private Money transactionAmount;

    public TransactionDTO(Long senderAccountId, Long recipientId, String recipientName, @DecimalMin(value = "0.01", message = "Amount must be above 0") BigDecimal amount, @Pattern(regexp = "(\\w{3})", message = "Please provide a valid currency") String currency) {
        try {
            this.senderAccountId = senderAccountId;
            this.recipientAccountId = recipientId;
            this.recipientName = recipientName;
            this.transactionAmount = new Money(amount, Currency.getInstance(currency.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide a valid currency");
        }

    }
}
