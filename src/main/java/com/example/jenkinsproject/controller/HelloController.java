package com.example.jenkinsproject.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${application.value1}")
    private String value1;

    @Value("${application.value2}")
    private String value2;

    @GetMapping("/ping")
    public String ping(
            @RequestParam(required = false) String param
    ) {
        return "good!!\n" + "/param = " + param;
    }

    @GetMapping("/value")
    public String value() {
        return String.format("value1: %s, value2: %s",value1, value2);
    }
}
