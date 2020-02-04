package com.battybuilds.testexamples.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MockBeanIntegrationTest {

    // This works if you have two beans of type RestTemplate named "myRestTemplate" and "blueService"
    // anywhere in the code they will be overridden as long as you match the arguments correctly and they do not conflict
    // with each other.
    // It also allows you to have a mock that returns one thing the first time and another the second time it is called.

    @MockBean
    @Qualifier("myRestTemplate")
    private RestTemplate myRestTemplate;

    @MockBean
    @Qualifier("blueService")
    private RestTemplate blueRestTemplate;

    @Test
    public void makeTwoCallsWithRedService() {
        when(myRestTemplate.exchange("redUrl", HttpMethod.GET, null, String.class)).thenReturn(
                new ResponseEntity<>(HttpStatus.BAD_REQUEST),
                new ResponseEntity<>(HttpStatus.OK)
        );
        ResponseEntity<String> redUrlResponse1 = myRestTemplate.exchange("redUrl", HttpMethod.GET, null, String.class);
        ResponseEntity<String> redUrlResponse2 = myRestTemplate.exchange("redUrl", HttpMethod.GET, null, String.class);
        assertThat(redUrlResponse1.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(redUrlResponse2.getStatusCode()).isEqualTo(HttpStatus.OK);

    }
}
