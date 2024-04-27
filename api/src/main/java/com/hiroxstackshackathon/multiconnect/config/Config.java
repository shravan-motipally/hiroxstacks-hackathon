package com.hiroxstackshackathon.multiconnect.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @Value("{hiro.url}")
    private String hiroUrl;

    @Bean
    public HiroConfig hiroConfig() {
        return new HiroConfig(hiroUrl);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder
                .basicAuthentication("user", "pass")
                .build();
    }
}
