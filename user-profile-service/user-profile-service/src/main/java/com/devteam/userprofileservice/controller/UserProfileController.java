package com.devteam.userprofileservice.controller;


import com.devteam.userprofileservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class UserProfileController {

    @Autowired
    private ReviewRepository reviewRepository;

    @RequestMapping(value = "/reviews/{author}", method = RequestMethod.GET)
    public ResponseEntity<?> getReviews(
            @PathVariable("author") String author)
    {
        try {
            return ResponseEntity.ok(reviewRepository.getAllByAuthor(author));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
