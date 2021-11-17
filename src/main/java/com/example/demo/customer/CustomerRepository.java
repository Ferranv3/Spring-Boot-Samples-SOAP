package com.example.demo.customer;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.guides.gs_producing_web_service.Customer;


@Component
public class CustomerRepository {
    private static final Map<String, Customer> customers = new HashMap<>();

    @PostConstruct
    public void initData() {
        Customer customer = new Customer();
        customer.setName("Paco");
        customer.setFirstName("Martinez");
        customer.setLastName("Mendez");
        customer.setEmail("email@email.com");
        customers.put(customer.getName(), customer);

        Customer customer1 = new Customer();
        customer1.setName("Pepe");
        customer1.setFirstName("Perez");
        customer1.setLastName("Mendez");
        customer1.setEmail("email@email.com");
        customers.put(customer1.getName(), customer1);

        Customer customer2 = new Customer();
        customer2.setName("Francisco");
        customer2.setFirstName("Newton");
        customer2.setLastName("Mendez");
        customer2.setEmail("email@email.com");
        customers.put(customer2.getName(), customer2);
    }

    public Customer findCustomer(String name) {
        Assert.notNull(name, "The customer's name must not be null");
        return customers.get(name);
    }
}
