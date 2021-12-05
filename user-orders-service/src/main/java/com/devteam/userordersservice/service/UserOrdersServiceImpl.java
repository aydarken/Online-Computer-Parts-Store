package com.devteam.userordersservice.service;

import com.devteam.userordersservice.model.OrderItem;
import com.devteam.userordersservice.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserOrdersServiceImpl {
    @Autowired
    OrderItemRepository orderItemRepository;

    public List<OrderItem> getAllOrders() {
        List<OrderItem> orders = new ArrayList<>();
        orderItemRepository.findAll()
                .forEach(orders::add);
        return orders;
    }

    public void addOrder(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public List<Optional<OrderItem>> getAllOrdersOfUser(long userid){
        List<Optional<OrderItem>> orders = new ArrayList<>();
        orders.add(orderItemRepository.findAllByUserId(userid));

        return orders;
    }

    public void updateOrder(long orderid, long itemId) {
        orderItemRepository.findById(orderid).map(orders -> {
            orders.setItemId(itemId);
            return orders;
        }).get();

    }
    public void deleteOrder(long orderid){
        orderItemRepository.deleteById(orderid);

    }
}
