package com.hiroxstackshackathon.multiconnect.controller;

import com.hiroxstackshackathon.multiconnect.model.Account;
import com.hiroxstackshackathon.multiconnect.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/account/{principal}/balance")
    public ResponseEntity<Account> balance(@PathVariable String principal) {
        Account account = accountService.getAccount(principal);
        return account != null ? ResponseEntity.ofNullable(account) : ResponseEntity.badRequest().build();
    }
}
