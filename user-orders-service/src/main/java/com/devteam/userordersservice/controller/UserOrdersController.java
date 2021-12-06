package com.devteam.userordersservice.controller;

import com.devteam.userordersservice.model.Order;
import com.devteam.userordersservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user-orders")
public class UserOrdersController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    // TODO: move logic into OrderService
    @PostMapping("/add/{userEmail}/{itemId}")
    public ResponseEntity<?> addOrder(
        @PathVariable("userEmail") String userEmail,
        @PathVariable("itemId") Long itemId
    ) {
        try {

            Order order = new Order();
            order.setEmail(userEmail);
            order.setItemId(itemId);

            orderRepository.save(order);

            return ResponseEntity.ok("Item " + itemId + " added to order successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/all/{userEmail}", method = RequestMethod.GET)
    public ResponseEntity<?> getByUser(
            @PathVariable("userEmail") String userEmail
    ) {
        try {
            return ResponseEntity.ok(orderRepository.findOrdersByEmail(userEmail));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}

