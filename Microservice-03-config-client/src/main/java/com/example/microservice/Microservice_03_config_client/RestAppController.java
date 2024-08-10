package com.example.microservice.Microservice_03_config_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config-client")
public class RestAppController {

    @Value("${msg}")
    private String message;

    @GetMapping("/message")
    public ResponseEntity<String> course(){
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
