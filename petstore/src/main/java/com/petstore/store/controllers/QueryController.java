package com.petstore.store.controllers;

import com.petstore.store.models.Customer;
import com.petstore.store.models.Invoice;
import com.petstore.store.models.Order;
import com.petstore.store.repositories.CustomerRepository;
import com.petstore.store.repositories.InvoiceRepository;
import com.petstore.store.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wichon on 2/5/17.
 */
@RestController
public class QueryController {
    private OrderRepository orderRepository;
    private InvoiceRepository invoiceRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public QueryController(OrderRepository orderRepository, InvoiceRepository invoiceRepository, CustomerRepository customerRepository){
        this.orderRepository = orderRepository;
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;
    }

    @RequestMapping(path= "/orders/{price}", method = RequestMethod.GET)
    public List<Order> orders(@PathVariable("price") final double price) {
        return orderRepository.getOrdersAbove25(price);
    }

    @RequestMapping(path= "/invoices", method = RequestMethod.GET)
    public List<Invoice> invoices() {
        return invoiceRepository.findAll();
    }

    @RequestMapping(path= "/customers", method = RequestMethod.GET)
    public List<Customer> customers() {
        return customerRepository.findAll();
    }
}