package com.petstore.store.runners;

import java.util.Date;
import java.util.HashSet;

import com.petstore.store.models.Customer;
import com.petstore.store.models.Invoice;
import com.petstore.store.models.Order;
import com.petstore.store.models.Pet;
import com.petstore.store.repositories.CustomerRepository;
import com.petstore.store.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by wichon on 2/5/17.
 */
@Component
public class DataLoader implements ApplicationRunner {
    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public DataLoader(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        Customer customer1 = new Customer("John");
        Customer customer2 = new Customer("Jane");
        Customer customer3 = new Customer("Juan");
        Customer customer4 = new Customer("Maria");

        /*customerRepository.save(new HashSet<Customer>() {
            customer1,
            customer2
        });*/

        Pet pet1 = new Pet(1L, "dog", "black", "fido", "instock", 50);
        Pet pet2 = new Pet(2L, "dog", "white", "daisy", "instock", 100);
        Pet pet3 = new Pet(3L, "dog", "brown", "mickey", "instock", 25);

        Order order1 = new Order(pet1, customer1);
        Order order2 = new Order(pet2, customer2);
        Order order3 = new Order(pet3, customer2);

        customer1.setOrders(new HashSet<Order>() {{
            add(order1);
        }});

        customer2.setOrders(new HashSet<Order>() {{
            add(order2);
            add(order3);
        }});

        Invoice invoice1 = new Invoice(order1.getPrice(), "Bought dog", order1);
        Invoice invoice2 = new Invoice(order2.getPrice(), "Bought dog", order2);
        Invoice invoice3 = new Invoice(order3.getPrice(), "Bought dog", order3);

        order1.setInvoice(invoice1);
        order2.setInvoice(invoice2);
        order3.setInvoice(invoice3);

        orderRepository.save(new HashSet<Order>(){{
            add(order1);
            add(order2);
            add(order3);
        }});
    }
}
