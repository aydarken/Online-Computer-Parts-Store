package com.devteam.userrefundservice.controller;


import com.devteam.userrefundservice.repository.OrderRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/refund")
public class UserRefundController {

    @Autowired private OrderRepository orderRepository;

    @RequestMapping(value = "/{orderId}", method = RequestMethod.POST)
    @HystrixCommand(
            fallbackMethod = "refundOrderFallback",
            threadPoolKey = "refundOrder",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            }
    )
    public ResponseEntity<?> refundOrder(
            @PathVariable("orderId") Long orderId
    ) {
        try {
            orderRepository.deleteById(orderId);
            return ResponseEntity.ok("Order refunded successfully!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity<?> refundOrderFallback(Long orderId){
        return ResponseEntity.badRequest().body("User orders is not available");
    }
}
