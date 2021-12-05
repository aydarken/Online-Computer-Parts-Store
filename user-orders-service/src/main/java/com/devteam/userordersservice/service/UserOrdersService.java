package com.devteam.userordersservice.service;

import com.devteam.userordersservice.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserOrdersService {
    List<OrderItem> getAllOrders();
    void addUser(OrderItem orderItem);
    List<Optional<OrderItem>> getAllOrdersOfUser(long userid);
    void updateOrder(long orderid, long itemId);
    void deleteOrder(long orderid);
}
