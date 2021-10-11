package com.devteam.userregistrationservice.controller;

import com.devteam.userregistrationservice.model.RegisteredUsers;
import com.devteam.userregistrationservice.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registration")
public class UserRegistrationController {

    @Autowired
    UserRegistrationService userRegistrationService;

    @RequestMapping("/register/{username}/{password}")
    public void registerUser(@PathVariable("username") String username, @PathVariable("password") String password) {
        userRegistrationService.registerUser(username, password);
    }

    @GetMapping("/registered_users")
    public RegisteredUsers getAllRegisteredUsers() {
        return new RegisteredUsers(userRegistrationService.getAllRegisteredUsers());
    }

}
