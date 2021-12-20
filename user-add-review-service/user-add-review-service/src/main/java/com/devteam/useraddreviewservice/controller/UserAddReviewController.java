package com.devteam.useraddreviewservice.controller;

import com.devteam.useraddreviewservice.model.ReviewEntity;
import com.devteam.useraddreviewservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/add-review")
public class UserAddReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addReview(@RequestBody ReviewEntity review) {
        try {
            reviewRepository.save(review);
            return ResponseEntity.ok("Review successfully added!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
