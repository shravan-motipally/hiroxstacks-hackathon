package com.hiroxstackshackathon.multiconnect.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class HiroConfig {
    private final String hiroUrl;

    @Autowired
    public HiroConfig(String hiroUrl) {
        this.hiroUrl = hiroUrl;
    }

    public String getHiroUrl() {
        return hiroUrl;
    }
}
