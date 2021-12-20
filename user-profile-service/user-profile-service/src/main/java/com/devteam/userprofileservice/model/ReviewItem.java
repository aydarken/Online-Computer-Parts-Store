package com.devteam.userprofileservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "review_item")
@Data
public class ReviewItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String author;
}
