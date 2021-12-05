package com.devteam.userrefundservice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "articles")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderId;
    private String userId;
    private String catalogItemId;
    private String status;

}
