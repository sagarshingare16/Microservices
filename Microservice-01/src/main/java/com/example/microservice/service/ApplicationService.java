package com.example.microservice.service;

import com.example.microservice.restController.Application1FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApplicationService {

    @Autowired
    private Application1FeignClient feignClient;

    public String hello() {
        /*RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity("http://localhost:8182/application/welcome",String.class);
        return "Hello and "+response.getBody()+"!"; */

        String response = feignClient.invokeGetWelcomeFromApplication2(); //calling MS2 method by feign client...
        return "Hello and "+response;
    }
}
