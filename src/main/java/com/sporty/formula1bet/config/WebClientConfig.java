package com.sporty.formula1bet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder
                .baseUrl("https://api.example.com") // optional default base URL
                .defaultHeader("Accept", "application/json")
                .build();
    }
}
