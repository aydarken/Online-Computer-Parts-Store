package com.devteam.userrefundservice.controller;

import com.devteam.userrefundservice.model.OrderItem;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(
            fallbackMethod = "refundOrderFallback",
            threadPoolKey = "refundOrder",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            }
    )
    public void refundOrder(
            @PathVariable String username,
            @PathVariable String partId
    ) {

            List<OrderItem> orderedItems = restTemplate
                    .getForObject("http://user-orders-service/user-orders/orders/" + username, List.class);

            if (orderedItems != null) {
                restTemplate.delete("http://user-orders-service/user-orders/orders/remove/" + partId);
            }

        }

    public void refundOrderFallback(String username, String partId){
        System.out.println("User orders is not available");
    }
}
