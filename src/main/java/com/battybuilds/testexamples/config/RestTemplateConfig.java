package com.battybuilds.testexamples.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    private RestTemplateBuilder builder;

    public RestTemplateConfig(RestTemplateBuilder builder) {
        this.builder = builder;
    }

    @Bean
    @Qualifier("myRestTemplate")
    public RestTemplate myRestTemplate() {
        return builder.build();
    }

    @Bean
    @Qualifier("blueService")
    public RestTemplate blueRestTemplate() {
        return builder.build();
    }

}
