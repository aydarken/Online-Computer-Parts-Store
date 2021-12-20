package com.devteam.userreviewsservice.repositories;

import com.devteam.userreviewsservice.models.ReviewItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewItem, Long> {
}
