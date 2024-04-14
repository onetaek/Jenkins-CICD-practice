package com.example.jenkinsproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

// github push event test
@RestController
public class HelloController {

    @Value("${application.value1}")
    private String value1;

    @Value("${application.value2}")
    private String value2;

    @GetMapping
    public Map<String, String> getClientInfo(HttpServletRequest request) {
        Map<String, String> clientInfo = new HashMap<>();
        // IP 주소
        clientInfo.put("ip: ", request.getRemoteAddr());
        // 포트 번호
        clientInfo.put("port: ", String.valueOf(request.getRemotePort()));
        // 요청 메서드
        clientInfo.put("method: ", request.getMethod());
        // 요청 URL
        clientInfo.put("url: ", request.getRequestURL().toString());
        // 요청 URI
        clientInfo.put("uri: ", request.getRequestURI());
        // 쿼리 문자열
        clientInfo.put("queryString: ", request.getQueryString());
        // 헤더 정보
        clientInfo.put("userAgent: ", request.getHeader("User-Agent"));

        clientInfo.put("value1: ", value1);

        clientInfo.put("value2: ", value2);
        return clientInfo;
    }

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
