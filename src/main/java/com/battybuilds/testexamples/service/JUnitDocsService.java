package com.battybuilds.testexamples.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JUnitDocsService {


    private RestTemplate restTemplate;

    public JUnitDocsService(RestTemplate myRestTemplate) {
        this.restTemplate = restTemplate;
    }

    public String makeCall() {
        ResponseEntity<String> responseEntity = restTemplate.exchange("https://junit.org/junit4/javadoc/latest/org/junit/experimental/theories/ParameterSignature.html", HttpMethod.GET, null, String.class);

        return responseEntity.getBody();
    }
}
