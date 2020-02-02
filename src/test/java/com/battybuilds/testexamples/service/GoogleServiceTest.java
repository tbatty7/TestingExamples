package com.battybuilds.testexamples.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoogleServiceTest {

    @Autowired
    GoogleService googleService;

    @Test
    public void callGoogle() {
        String response = googleService.callGoogle();
        assertEquals(" | gb1 | gb1 | gb1 | gb1 | gb1 | gb1 | gb1 | gb1 | gb1 | gbi | gbf | gb4 | gb4 | gb4 | gbh | gbh | \"ds\" | \"lst\" | \"ds\" | \"lsbb\" | \"lsb\" | \"ds\" | \"lsbb\" | \"lsb\" | \"fl | \"szppmdbYutt__middle-slot-promo\" | \"NKcBbd\"", response);
    }
}
