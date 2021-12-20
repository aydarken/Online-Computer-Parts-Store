package com.devteam.userprofileservice.repository;

import com.devteam.userprofileservice.model.ReviewItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewItem, Long> {


    @Query("SELECT COUNT(item) FROM ReviewItem item WHERE ?1 = item.author")
    Long countUsers(String email);

    List<ReviewItem> getAllByAuthor(String author);
}
