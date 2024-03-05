package com.example.jenkinsproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/ping")
    public String ping(
            @RequestParam(required = false) String param
    ) {
        return "good!!\n" + "/param = " + param;
    }

}
