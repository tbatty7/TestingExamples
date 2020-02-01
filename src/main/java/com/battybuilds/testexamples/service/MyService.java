package com.battybuilds.testexamples.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyService {

    private RestTemplate restTemplate;

    public MyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String makeCall(String request) {
        HttpEntity<String> httpEntityRequest = new HttpEntity<>(request);
        ResponseEntity<String> responseEntity = restTemplate.exchange("url", HttpMethod.POST, httpEntityRequest, String.class);
        return responseEntity.getBody();
    }
}
