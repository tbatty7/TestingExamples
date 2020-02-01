package com.battybuilds.testexamples.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyControllerTest {

    @Autowired
    MyController controller;

    @MockBean
    RestTemplate restTemplate;

    @Test
    public void callsService() {
        when(restTemplate.exchange(anyString(),eq(HttpMethod.POST), any(HttpEntity.class), eq(String.class))).thenReturn(new ResponseEntity<String>("hi",HttpStatus.OK));
        ResponseEntity response = controller.receive("");
        assertEquals("hi", response.getBody());
    }
}
