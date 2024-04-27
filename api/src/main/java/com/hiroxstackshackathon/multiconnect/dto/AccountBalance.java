package com.hiroxstackshackathon.multiconnect.dto;

import com.hiroxstackshackathon.multiconnect.model.Account;

public class AccountBalance {
    private Stx stxObject;

    public Stx getStxObject() {
        return stxObject;
    }

    public static Account from(AccountBalance accountBalance) {
        Account account = new Account();
        account.setBalance(accountBalance.getStxObject().getBalance());
        return account;
    }
}
