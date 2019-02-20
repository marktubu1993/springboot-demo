package com.springboot.example.jpa.web;

import com.springboot.example.jpa.config.MyConfig;
import com.springboot.example.jpa.domain.User;
import com.springboot.example.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author mark-liu
 */
@RestController
public class MyController {

    @Autowired
    MyConfig config;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/hi")
    public HttpEntity<?> addUSer() {
        return ResponseEntity.ok(config);
    }

    @GetMapping(value = "/users")
    public String postAccount() {
        String name = "mark";
        String age = "22";
        User user = new User();
        user.setName(name);
        user.setAge(age);
        User user1 = userRepository.save(user);
        return user1.toString();
    }

}
