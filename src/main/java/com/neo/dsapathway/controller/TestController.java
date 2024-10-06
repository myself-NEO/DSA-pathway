package com.neo.dsapathway.controller;

import com.neo.dsapathway.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://keshav-jha.netlify.app")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/greet")
    public ResponseEntity<String> getGreetings() {
        String greeting = testService.getGreetings();
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
