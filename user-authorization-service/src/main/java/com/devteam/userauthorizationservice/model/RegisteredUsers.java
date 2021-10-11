package com.devteam.userauthorizationservice.model;

import java.util.List;

public class RegisteredUsers {

    private List<RegisteredUser> registeredUserList;

    public RegisteredUsers(List<RegisteredUser> registeredUserList) {
        this.registeredUserList = registeredUserList;
    }

    public RegisteredUsers() {

    }

    public List<RegisteredUser> getRegisteredUserList() {
        return registeredUserList;
    }

    public void setRegisteredUserList(List<RegisteredUser> registeredUserList) {
        this.registeredUserList = registeredUserList;
    }
}
