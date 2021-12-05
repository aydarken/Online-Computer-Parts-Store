package com.devteam.userregistrationservice.controller;

import com.devteam.userregistrationservice.model.UserEntity;
import com.devteam.userregistrationservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "registerUserFallback")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("User successfully registered!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity registerUserFallback(UserEntity user) {
        return ResponseEntity.badRequest().body("Service is not available");
    }


}
