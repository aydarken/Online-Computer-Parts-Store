package com.devteam.userrefundservice.model;

public class OrderItem {

    private String orderId;
    private String name;
    private String status;

    public OrderItem(String orderId, String name, String status) {
        this.orderId = orderId;
        this.status = status;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
