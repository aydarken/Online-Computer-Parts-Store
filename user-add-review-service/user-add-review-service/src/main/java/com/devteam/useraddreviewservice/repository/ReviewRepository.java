package com.devteam.useraddreviewservice.repository;

import com.devteam.useraddreviewservice.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

}