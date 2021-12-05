package com.devteam.userregistrationservice.service;

import com.devteam.userregistrationservice.exceptions.UserAlreadyExistException;
import com.devteam.userregistrationservice.exceptions.UserValidationException;
import com.devteam.userregistrationservice.model.UserEntity;

public interface UserService {

    UserEntity registration(UserEntity userEntity) throws UserAlreadyExistException, UserValidationException;
}