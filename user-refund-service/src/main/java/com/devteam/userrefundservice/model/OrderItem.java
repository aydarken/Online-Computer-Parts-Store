package com.devteam.userrefundservice.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItem {

    private String orderId;
    private String name;
    private String status;

    public OrderItem(String orderId, String name, String status) {
        this.orderId = orderId;
        this.status = status;
        this.name = name;
    }


}
