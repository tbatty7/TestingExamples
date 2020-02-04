package com.battybuilds.testexamples.service;

import com.battybuilds.testexamples.transformer.MyTransformer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleService {

    private RestTemplate restTemplate;
    private MyTransformer transformer;

    public GoogleService(RestTemplate myRestTemplate, MyTransformer transformer) {
        this.restTemplate = restTemplate;
        this.transformer = transformer;
    }

    public String makeCall(String request) {
        HttpEntity<String> httpEntityRequest = new HttpEntity<>(request);
        ResponseEntity<String> responseEntity = restTemplate.exchange("url", HttpMethod.POST, httpEntityRequest, String.class);
        return responseEntity.getBody();
    }

    public String callGoogle() {
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://www.google.com", HttpMethod.GET, null, String.class);
        String htmlFromGoogle = responseEntity.getBody();
        String scrapedClasses = transformer.scrapeClasses(htmlFromGoogle);
        return scrapedClasses;
    }
}
