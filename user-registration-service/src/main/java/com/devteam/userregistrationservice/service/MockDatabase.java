package com.devteam.userregistrationservice.service;

import com.devteam.userregistrationservice.model.RegisteredUser;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MockDatabase {

    private ArrayList<RegisteredUser> registeredUsers = new ArrayList<>();

    public MockDatabase() {
        initDb();
    }

    private void initDb() {
        addRegisteredUser("Jack", "jacksparrow");
        addRegisteredUser("Cobb", "inception");
        addRegisteredUser("Beatrix", "beatrixkiddo");
        addRegisteredUser("Harry", "gryffindor");
    }

    public void addRegisteredUser(String username, String password) {
        registeredUsers.add(new RegisteredUser(username, password));
    }

    public ArrayList<RegisteredUser> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(ArrayList<RegisteredUser> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }
}
