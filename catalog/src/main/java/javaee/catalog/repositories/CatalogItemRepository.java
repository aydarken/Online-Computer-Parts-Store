package javaee.catalog.repositories;

import javaee.catalog.models.CatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogItemRepository extends JpaRepository<CatalogItem, Long> {
}
