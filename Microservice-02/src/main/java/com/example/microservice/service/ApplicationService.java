package com.example.microservice.service;

import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    public String welcome() {
        return "welcome!";
    }
}
