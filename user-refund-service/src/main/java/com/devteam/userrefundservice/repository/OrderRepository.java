package com.devteam.userrefundservice.repository;

import com.devteam.userrefundservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findOrderByEmail(String email);
}
