package com.petstore.inventory.models;

import javax.persistence.*;

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
    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    protected Pet() {}

    public Pet(String type, String color, String name, String status) {
        this.type = type;
        this.color = color;
        this.name = name;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Pet[Id=%s, Name=%s, Type=%s, Color=%s, Status=%s]", id, name, type, color, status);
    }
}