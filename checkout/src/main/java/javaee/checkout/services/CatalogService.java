package javaee.checkout.services;

import java.util.List;
import javaee.checkout.models.Item;

public interface CatalogService {
    public List<Item> getAllItems();
    public Item getOneItem(Long id);
}