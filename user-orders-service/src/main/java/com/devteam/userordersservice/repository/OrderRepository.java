package com.devteam.userordersservice.repository;

import com.devteam.userordersservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrdersByEmail(String email);
}
