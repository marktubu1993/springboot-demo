package com.springboot.example.demo.web;

import com.springboot.example.demo.config.MyConfig;
import com.springboot.example.demo.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mark-liu
 */
@RestController
public class MyController {

    @Autowired
    MyConfig config;

    @Autowired
    TestConfig testConfig;


    @GetMapping(value = "hi")
    public HttpEntity<?> hi() {
        return ResponseEntity.ok(config);
    }

    @GetMapping(value = "hi/test")
    public HttpEntity<?> test(){
        return ResponseEntity.ok(testConfig);
    }
}
