package com.devteam.userordersservice.controller;

import com.devteam.userordersservice.model.OrderItem;
import com.devteam.userordersservice.service.UserOrdersService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user-orders")
public class UserOrdersController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserOrdersService userOrdersService;

    @GetMapping("/orders/{userid}")
    @HystrixCommand(fallbackMethod = "OrdersFallback")
    public List<Optional<OrderItem>> getOrders(@PathVariable("userid") Long userid) {

        List<Optional<OrderItem>> orderItems = userOrdersService.getAllOrdersOfUser(userid);

        List catalogItems = restTemplate.getForObject("http://catalog-service/items/", List.class);

        if (catalogItems != null) {
            System.out.println("catalogItems="+catalogItems);
        }

        return orderItems;
    }


    public void OrdersFallback(String username) {
        System.out.println("User orders is not available");
    }

    @PostMapping("/orders/")
    @HystrixCommand(fallbackMethod = "addOrderFallback")
    public void addOrder(@RequestBody OrderItem orderItem) {
        userOrdersService.addUser(orderItem);
    }

    public void addOrderFallback(OrderItem orderItem){
        System.out.println("Service now is not available");
    }

    @DeleteMapping("/orders/remove/{partId}")
    @HystrixCommand(fallbackMethod = "removeOrderFallback")
    public void removeOrder(@PathVariable("partId") Long partId) {
        userOrdersService.deleteOrder(partId);
    }
    public void removeOrderFallback(String username) {
        System.out.println("User orders is not available. Your order will remove soon!");
    }

}
