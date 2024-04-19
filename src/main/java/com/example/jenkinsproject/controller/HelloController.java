package com.example.jenkinsproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Value("${application.value1}")
    private String value1;

    @Value("${application.value2}")
    private String value2;

    @GetMapping
    public Map<String, String> getClientInfo(HttpServletRequest request) {
        System.out.println("request = " + request);
        return Map.of(
                "ip: ", request.getRemoteAddr(),
                "port: ", String.valueOf(request.getRemotePort()),
                "method: ", request.getMethod(),
                "url: ", request.getRequestURL().toString(),
                "uri: ", request.getRequestURI(),
                "queryString: ", request.getQueryString(),
                "userAgent: ", request.getHeader("User-Agent"),
                "value1: ", value1,
                "value2: ", value2
        )
    }
}
