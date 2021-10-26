package javaee.catalog.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
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

}