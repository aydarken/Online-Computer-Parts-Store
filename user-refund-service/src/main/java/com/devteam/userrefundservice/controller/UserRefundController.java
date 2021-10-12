package com.devteam.userrefundservice.controller;

import com.devteam.userrefundservice.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/refund")
public class UserRefundController {

    @Autowired
    private RestTemplate restTemplate;

       @RequestMapping("/{username}/{partId}")
    public void refundOrder(
            @PathVariable String username,
            @PathVariable String partId
    ) {

        if (username.equals("Cobb")) {
            List<OrderItem> orderedItems = restTemplate
                    .getForObject("http://user-orders-service/user-orders/orders/" + username, List.class);

            if (orderedItems != null) {
                restTemplate.delete("http://user-orders-service/user-orders/orders/remove/" + partId);
            }

        }
    }
}
