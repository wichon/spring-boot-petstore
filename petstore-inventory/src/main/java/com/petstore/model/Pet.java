package com.petstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by wichon on 1/18/17.
 */

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String type;
    private String color;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Pet() {}

    public Pet(String type, String color, String name) {
        this.type = type;
        this.color = color;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Pet[Id=%s, Name=%s, Type=%s, Color=%s]", id, name, type, color);
    }
}
