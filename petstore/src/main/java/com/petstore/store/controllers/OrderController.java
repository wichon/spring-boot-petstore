package com.petstore.store.controllers;

import com.petstore.store.models.Customer;
import com.petstore.store.models.Invoice;
import com.petstore.store.models.Order;
import com.petstore.store.models.Pet;
import com.petstore.store.repositories.CustomerRepository;
import com.petstore.store.repositories.InvoiceRepository;
import com.petstore.store.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wichon on 2/10/17.
 */
@RestController
public class OrderController {
    private OrderRepository orderRepository;
    private InvoiceRepository invoiceRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository, InvoiceRepository invoiceRepository, CustomerRepository customerRepository){
        this.orderRepository = orderRepository;
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;
    }

    @RequestMapping(path= "/order/add/{petId}/{customerId}", method = RequestMethod.GET)
    public long add(@PathVariable("petId") final long petId, @PathVariable("customerId") final long customerId) {
        // Get pet info by pet id, by querying the Petstore Inventory app
        Pet pet = new Pet();
        pet.setId(petId);
        pet.setStatus("adopt");
        pet.setPrice(30);
        Customer customer = customerRepository.findOne(customerId);
        Order order = new Order(new Pet(), customer);
        Invoice invoice = new Invoice(order.getPrice(), String.format("%s %s", pet.getStatus(), pet.getName()), order);
        order.setInvoice(invoice);
        orderRepository.save(order);
        return orderRepository.count();
    }
}
