package com.springboot.example.jpa.web;

import com.springboot.example.jpa.config.MyConfig;
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


    @GetMapping(value = "hi")
    public HttpEntity<?> hi() {
        return ResponseEntity.ok(config);
    }

}
