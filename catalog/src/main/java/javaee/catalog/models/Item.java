package javaee.catalog.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Item {

    private @Id @GeneratedValue Long id;
    private String name;
    private String description;
    private double price;

    public Item() {}

    public Item(
        String name,
        String description,
        double price
    ) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + this.id +
            ", name=" + this.name +
            ", description=" + this.description +
            ", price=" + this.price + "}";
    }

}