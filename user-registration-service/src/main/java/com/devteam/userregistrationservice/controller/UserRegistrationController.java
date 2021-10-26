package com.devteam.userregistrationservice.controller;

import com.devteam.userregistrationservice.model.RegisteredUser;
import com.devteam.userregistrationservice.model.RegisteredUsers;
import com.devteam.userregistrationservice.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.ArrayList;

@RestController
@RequestMapping("registration")
public class UserRegistrationController {

    @Autowired
    UserRegistrationService userRegistrationService;

    @RequestMapping("/register/{username}/{password}")
    @HystrixCommand(fallbackMethod = "registerUserFallback")
    public void registerUser(@PathVariable("username") String username, @PathVariable("password") String password) {
        userRegistrationService.registerUser(username, password);
    }

    public void registerUserFallback(String username, String password) {
        System.out.println("User not registered: Service Unavailable");
    }

    @GetMapping("/registered_users")
    @HystrixCommand(fallbackMethod = "getAllRegisteredUsersFallback")
    public RegisteredUsers getAllRegisteredUsers() {
        return new RegisteredUsers(userRegistrationService.getAllRegisteredUsers());
    }

    public RegisteredUsers getAllRegisteredUsersFallback() {
        return new RegisteredUsers(new ArrayList<RegisteredUser>());
    }



}
