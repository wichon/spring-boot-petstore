package com.petstore.store.models;

import javax.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Created by wichon on 2/4/17.
 */
@Entity(name = "orders")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long petId;
    @Column(precision = 2)
    private double price;
    private Date created;
    private Date modified;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="customer_id", referencedColumnName="id")
    private Customer customer;
    @OneToOne(mappedBy="order", targetEntity=Invoice.class, cascade = CascadeType.ALL)
    //@JsonManagedReference
    private Invoice invoice;

    public Order() {}

    public Order(Pet pet, Customer customer) {
        this.petId = pet.getId();
        this.price = pet.getPrice();
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @PrePersist
    public void onOrderCreation() {
        this.created = new Date();
        this.modified = new Date();
    }

    @PreUpdate
    public void onOrderModification() {
        this.modified = new Date();
    }
}
