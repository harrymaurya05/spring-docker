package com.spring.security.learn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/test")
public class TestController {
    @GetMapping(value = "/admin")
    public ResponseEntity<String> testAdmin(){
        return ResponseEntity.ok("Admin api!");
    }
    @GetMapping(value = "/user")
    public ResponseEntity<String> testUser(){
        return ResponseEntity.ok("User api!");
    }

    @GetMapping(value = "/public")
    public ResponseEntity<String> testPublic(){
        return ResponseEntity.ok("Public api!");
    }
    @GetMapping(value = "/public/new")
    public ResponseEntity<String> testNewPublic(){
        return ResponseEntity.ok("New Public api!");
    }

    @GetMapping(value = "/public/my")
    public ResponseEntity<String> testMyPublic(){
        return ResponseEntity.ok("Hariom Public api!");
    }
}
