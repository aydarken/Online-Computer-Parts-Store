package com.devteam.userordersservice.controller;

import com.devteam.userordersservice.model.Item;
import com.devteam.userordersservice.model.OrderItem;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user-orders")
public class UserOrdersController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/orders/{username}")
    @HystrixCommand(fallbackMethod = "OrdersFallback")
    public List<Item> getOrders(@PathVariable("username") String username) {

        List<Item> orderItems = new ArrayList<>();

        if (username.equals("Cobb")) {

            List<Item> catalogItems = restTemplate.getForObject("http://catalog-service/items/", List.class);

            if (catalogItems != null) {
                System.out.println("catalogItems="+catalogItems);
            }

            return catalogItems;
        }

        return orderItems;
    }
    public void OrdersFallback(String username) {
        System.out.println("User orders is not available");
    }

    @DeleteMapping("/orders/remove/{partId}")
    @HystrixCommand(fallbackMethod = "removeOrderFallback")
    public void removeOrder(@PathVariable("partId") String partId) {
        System.out.println("Order " + partId + "removed");
    }
    public void removeOrderFallback(String username) {
        System.out.println("User orders is not available. Your order will remove soon!");
    }

}
