package com.example.microservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApplicationService {

    public String hello() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity("http://localhost:8182/application/welcome",String.class);
        return "Hello and "+response.getBody()+"!";
    }
}
