package com.neo.dsapathway.service.impl;

import com.neo.dsapathway.service.TestService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String getGreetings() {
        return "Hello, NEO!";
    }
}
