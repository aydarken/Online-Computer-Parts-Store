package com.devteam.userauthorizationservice.repository;

import com.devteam.userauthorizationservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}