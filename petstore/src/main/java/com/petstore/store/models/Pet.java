package com.petstore.store.models;

/**
 * Created by wichon on 2/4/17.
 */
public class Pet {
    private Long id;
    private String type;
    private String color;
    private String name;
    private String status;
    private double price;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Pet() {}

    public Pet(Long id, String type, String color, String name, String status, double price) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.name = name;
        this.status = status;
        this.price = price;
    }


    @Override
    public String toString() {
        return String.format("Pet[Id=%s, Name=%s, Type=%s, Color=%s, Status=%s]", id, name, type, color, status);
    }
}