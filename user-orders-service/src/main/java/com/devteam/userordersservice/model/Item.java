package com.devteam.userordersservice.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {

    private String name;

    public Item() {}

    public Item(String name) {
        this.name = name;
    }

}
