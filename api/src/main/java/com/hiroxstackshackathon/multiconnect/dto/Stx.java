package com.hiroxstackshackathon.multiconnect.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stx {
    private String balance;

    public String getBalance() {
        return balance;
    }
}
