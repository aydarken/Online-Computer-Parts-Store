package com.devteam.userregistrationservice.service;

import com.devteam.userregistrationservice.model.RegisteredUser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class UserRegistrationServiceImpl implements UserRegistrationService {

    MockDatabase database = new MockDatabase();

    @Override
    public void registerUser(String username, String password) {
        database.addRegisteredUser(username, password);
    }

    @Override
    public ArrayList<RegisteredUser> getAllRegisteredUsers() {

        return database.getRegisteredUsers();
    }
}
