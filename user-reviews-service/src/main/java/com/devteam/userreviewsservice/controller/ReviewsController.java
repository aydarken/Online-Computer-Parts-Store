package com.devteam.userreviewsservice.controller;

import com.devteam.userreviewsservice.models.ReviewItem;
import com.devteam.userreviewsservice.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private ReviewRepository repository;

    @GetMapping("/all")
    public List<ReviewItem> all() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ReviewItem one(@PathVariable Long id) {

        if (repository.findById(id).isPresent()) {
            return repository.findById(id).get();
        } else {
            return null;
        }
    }
}
