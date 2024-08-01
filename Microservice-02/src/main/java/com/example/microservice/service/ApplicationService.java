package com.example.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    private Environment environment;

    public String welcome() {
        return "welcome! from application service running on port " + environment.getProperty("server.port");
    }
}
