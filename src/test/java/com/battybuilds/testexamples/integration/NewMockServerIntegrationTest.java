package com.battybuilds.testexamples.integration;

import com.battybuilds.testexamples.TestexamplesApplication;
import com.battybuilds.testexamples.config.RestTemplateConfig;
import com.battybuilds.testexamples.service.GoogleService;
import com.battybuilds.testexamples.transformer.MyTransformer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest({GoogleService.class, MyTransformer.class, RestTemplateConfig.class, TestexamplesApplication.class})
@RunWith(SpringRunner.class)
public class NewMockServerIntegrationTest {

    @Autowired
    MockRestServiceServer server;

    @Autowired
    GoogleService googleService;

    @Autowired
    ObjectMapper objectMapper;

    String response;

    @Before
    public void setUp() {
        // I could write an object as json string with object mapper if I wanted to
        response = "<a class=hello>";
        server.expect(requestTo("http://www.google.com")).andRespond(withSuccess(response, MediaType.TEXT_PLAIN));
    }

    @Test
    public void canCallService() {
        String response = googleService.callGoogle();
        assertEquals(" | hello", response);
    }
}
