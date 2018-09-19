package com.own.microservice.provide.rfriends.circle.album.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试")
@RestController
public class TestController {
    @Value("${TEST}")
    private String TEST;
    @Value("${Testt}")
    private String Testt;

    @GetMapping("/test")
    private String test(){
        return TEST;
    }
    @GetMapping("/test1")
    private String test1(){
        return Testt;
    }
}
