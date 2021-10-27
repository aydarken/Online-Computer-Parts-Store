package com.devteam.userauthorizationservice.controller;

import com.devteam.userauthorizationservice.model.RegisteredUser;
import com.devteam.userauthorizationservice.model.RegisteredUsers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("authorization")
public class UserAuthorizationController {

    @Autowired
    public RestTemplate restTemplate;

    @RequestMapping("/authorize/{username}/{password}")
    @HystrixCommand(
            fallbackMethod = "authorizeUserFallback",
            threadPoolKey = "authorizeUser",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            }
    )
    public void authorizeUser(@PathVariable("username") String username, @PathVariable("password")  String password) {

        RegisteredUsers registeredUsers = restTemplate
                .getForObject("http://user-registration-service/registration/registered_users", RegisteredUsers.class);

        if (registeredUsers != null) {

            boolean isAuthorized = false;

            for (RegisteredUser registeredUser : registeredUsers.getRegisteredUserList()) {

                if (username.equals(registeredUser.getUsername())
                        && password.equals(registeredUser.getPassword())) {
                    isAuthorized = true;
                    break;
                }

            }

            if (isAuthorized) {
                System.out.println("Successfully authorized!");
            } else {
                System.out.println("Username or password is wrong!");
            }
        } else {
            System.out.println("There is no registered users!");
        }

    }

    public void authorizeUserFallback(String username, String password) {
        System.out.println("User not authorized: Service Unavailable");
    }
}
