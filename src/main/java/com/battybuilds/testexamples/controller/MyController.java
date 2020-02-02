package com.battybuilds.testexamples.controller;

import com.battybuilds.testexamples.service.GoogleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private GoogleService service;

    public MyController(GoogleService service) {
        this.service = service;
    }

    @PostMapping("/update")
    public ResponseEntity<String> receive(String request) {
        String response = service.makeCall(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
