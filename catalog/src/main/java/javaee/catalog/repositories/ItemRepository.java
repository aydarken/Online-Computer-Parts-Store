package javaee.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import javaee.catalog.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

} 