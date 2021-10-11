package com.devteam.userregistrationservice.model;

import java.util.List;

public class RegisteredUsers {

    private List<RegisteredUser> registeredUserList;

    public RegisteredUsers(List<RegisteredUser> registeredUserList) {
        this.registeredUserList = registeredUserList;
    }

    public List<RegisteredUser> getRegisteredUserList() {
        return registeredUserList;
    }

    public void setRegisteredUserList(List<RegisteredUser> registeredUserList) {
        this.registeredUserList = registeredUserList;
    }
}
