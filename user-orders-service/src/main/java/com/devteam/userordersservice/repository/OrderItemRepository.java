package com.devteam.userordersservice.repository;

import com.devteam.userordersservice.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
    Optional<OrderItem> findAllByUserId(Long aLong);
}
