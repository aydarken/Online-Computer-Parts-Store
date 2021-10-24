package com.devteam.userregistrationservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisteredUser {

    private Long id;
    private String username;
    private String password;

    public RegisteredUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
