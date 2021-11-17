package com.example.demo.customer;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.guides.gs_producing_web_service.Customer;


@Component
public class CustomerRepository {
    private static final Map<Long, Customer> customers = new HashMap<>();

    @PostConstruct
    public void initData() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Paco");
        customer.setFirstName("Martinez");
        customer.setLastName("Mendez");
        customer.setEmail("email@email.com");
        customers.put(customer.getId(), customer);

        Customer customer1 = new Customer();
        customer1.setId(2);
        customer1.setName("Pepe");
        customer1.setFirstName("Perez");
        customer1.setLastName("Mendez");
        customer1.setEmail("email@email.com");
        customers.put(customer1.getId(), customer1);

        Customer customer2 = new Customer();
        customer2.setId(3);
        customer2.setName("Francisco");
        customer2.setFirstName("Newton");
        customer2.setLastName("Mendez");
        customer2.setEmail("email@email.com");
        customers.put(customer2.getId(), customer2);
    }

    /*public Customer findCustomerByName(String name) {
        Assert.notNull(name, "The customer's name must not be null");
        return customers.get(name);
    }*/

    public Customer findCustomerByID(long id) {
        Assert.notNull(id, "The customer's id must not be null");
        return customers.get(id);
    }

    public Customer deleteCustomerByID(long id) {
        Assert.notNull(id, "The customer's id must not be null");
        return customers.remove(id);
    }
}
