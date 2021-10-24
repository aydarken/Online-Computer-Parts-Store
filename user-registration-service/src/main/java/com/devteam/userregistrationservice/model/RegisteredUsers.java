package com.devteam.userregistrationservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RegisteredUsers {

    private List<RegisteredUser> registeredUserList;

    public RegisteredUsers(List<RegisteredUser> registeredUserList) {
        this.registeredUserList = registeredUserList;
    }
}
