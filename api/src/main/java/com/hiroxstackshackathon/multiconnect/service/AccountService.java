package com.hiroxstackshackathon.multiconnect.service;

import com.hiroxstackshackathon.multiconnect.config.HiroConfig;
import com.hiroxstackshackathon.multiconnect.dto.AccountBalance;
import com.hiroxstackshackathon.multiconnect.model.Account;
import com.hiroxstackshackathon.multiconnect.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.hiroxstackshackathon.multiconnect.service.Constants.ACCOUNT_BALANCE_URL;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final HiroConfig hiroConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public AccountService(AccountRepository accountRepository, HiroConfig hiroConfig, RestTemplate restTemplate) {
        this.accountRepository = accountRepository;
        this.hiroConfig = hiroConfig;
        this.restTemplate = restTemplate;
    }

    public Account getAccount(String principal) {
        ResponseEntity<AccountBalance> accountBalanceResponseEntity = restTemplate.getForEntity(
                getAccountBalanceUrl(principal), AccountBalance.class);
        if (accountBalanceResponseEntity.getStatusCode().is2xxSuccessful()
        && accountBalanceResponseEntity.getBody() != null) {
            return AccountBalance.from(accountBalanceResponseEntity.getBody());
        } else {
            return null;
        }
    }

    private String getAccountBalanceUrl(String principal) {
        return hiroConfig.getHiroUrl() + ACCOUNT_BALANCE_URL.replace(":principal", principal);
    }
}
