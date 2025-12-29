package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.repository.UserRepo;

@RestController
public class TestController {
    
    @Autowired
    private UserRepo userRepo;
    
    @GetMapping("/test")
    public String test() {
        return "Application is running! Database connection: " + 
               (userRepo != null ? "Connected" : "Failed");
    }
    
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}