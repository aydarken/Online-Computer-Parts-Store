package com.devteam.userregistrationservice.service;

import com.devteam.userregistrationservice.model.RegisteredUser;

import java.util.List;

public interface UserRegistrationService {

    void registerUser(String username, String password);
    List<RegisteredUser> getAllRegisteredUsers();
}
