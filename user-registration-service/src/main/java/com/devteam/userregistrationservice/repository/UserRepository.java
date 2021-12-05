package com.devteam.userregistrationservice.repository;

import com.devteam.userregistrationservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);
}