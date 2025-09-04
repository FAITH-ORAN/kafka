package com.example.account_service.controller;

import com.example.account_service.dto.Account;
import com.example.account_service.dto.AccountEvent;
import com.example.account_service.kafka.AccountProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class AccountController {

    private AccountProducer accountProducer;

    public AccountController(AccountProducer accountProducer) {
        this.accountProducer = accountProducer;
    }

    @PostMapping("/accounts")
    public String createAccount(@RequestBody Account account){
        account.setAccountId(UUID.randomUUID().toString());
        account.setAccountCreatedAt(LocalDateTime.now());
        AccountEvent accountEvent = new AccountEvent();
        accountEvent.setStatus("CREATED");
        accountEvent.setMessage("new account is created");
        accountEvent.setAccount(account);

        accountProducer.sendMessage(accountEvent);

        return "Account is created successfully ...";
    }
}
