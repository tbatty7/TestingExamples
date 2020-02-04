package com.battybuilds.testexamples.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.any;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withBadRequest;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MockServerIntegrationTest {

    MockRestServiceServer mockRestServiceServer;

    @Autowired
    @Qualifier("myRestTemplate")
    RestTemplate restTemplate;

    @Before
    public void setUp() {
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test(expected = HttpServerErrorException.InternalServerError.class)
    public void throwsExceptionOn500() {
        mockRestServiceServer.expect(requestTo(any(String.class))).andRespond(withServerError());
        restTemplate.exchange("http://url.com", HttpMethod.GET, null, String.class);
    }

    @Test(expected = HttpClientErrorException.BadRequest.class)
    public void throwsExceptionOn400() {
        mockRestServiceServer.expect(requestTo(any(String.class))).andRespond(withBadRequest());
        restTemplate.exchange("http://url.com", HttpMethod.GET, null, String.class);
    }
}
