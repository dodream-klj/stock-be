package com.soongsil.klj.stockbe.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldApi {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}
