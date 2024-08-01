package com.example.microservice.restController;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "APPLICATION-02")
public interface Application1FeignClient {

    @GetMapping("/application/welcome")
    String invokeGetWelcomeFromApplication2();
}
