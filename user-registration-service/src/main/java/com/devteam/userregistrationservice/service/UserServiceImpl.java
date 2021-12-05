package com.devteam.userregistrationservice.service;

import com.devteam.userregistrationservice.exceptions.UserAlreadyExistException;
import com.devteam.userregistrationservice.exceptions.UserValidationException;
import com.devteam.userregistrationservice.model.UserEntity;
import com.devteam.userregistrationservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserEntity registration(UserEntity user) throws UserAlreadyExistException, UserValidationException {

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistException("User with this email already exists!");
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            throw new UserValidationException("password and confirm password are not equal");
        }

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            throw new UserValidationException("Password length is not correct");
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}