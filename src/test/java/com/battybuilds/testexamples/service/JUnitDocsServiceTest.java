package com.battybuilds.testexamples.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JUnitDocsServiceTest {

    @Autowired
    JUnitDocsService service;

    @Test
    public void callWikipedia() {
        String response = service.makeCall();
        assertEquals("", response);
    }
}
