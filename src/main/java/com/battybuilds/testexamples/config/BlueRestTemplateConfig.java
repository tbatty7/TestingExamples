package com.battybuilds.testexamples.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BlueRestTemplateConfig {

    private RestTemplateBuilder builder;

    public BlueRestTemplateConfig(RestTemplateBuilder builder) {
        this.builder = builder;
    }

    @Bean
    @Qualifier("blueService")
    public RestTemplate blueRestTemplate() {
        return builder.build();
    }
}
