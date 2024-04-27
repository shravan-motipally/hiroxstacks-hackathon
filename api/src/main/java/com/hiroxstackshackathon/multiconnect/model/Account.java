package com.hiroxstackshackathon.multiconnect.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigInteger;
import java.util.UUID;


@Entity
@Table(schema = "DEFAULT", name = "ACCOUNT")
public class Account {
    @Id
    private UUID id;
    @Column(name="balance")
    private BigInteger balance;

    @SuppressWarnings("unused")
    public Account() {}

    public BigInteger getBalance() {
        return balance;
    }

    public void setBalance(String bal) {
        balance = new BigInteger(bal);
    }
}
