package com.example.demo.customer;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import io.spring.guides.gs_producing_web_service.Customer;
import io.spring.guides.gs_producing_web_service.ModifyCustomerRequest;


@Component
public class CustomerRepository {
    private static final Map<Long, Customer> customers = new HashMap<>();
    private static int id = 3;

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
    public Customer createCustomer(String name, String firstName, String lastName, String email) {
        this.id = this.id + 1;
        Customer customer = new Customer();
        System.out.println(this.id);
        customer.setId(this.id);
        customer.setName(name);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customers.put(customer.getId(), customer);
        return customers.get(customer.getId());
    }

    public Customer findCustomerByID(long id) {
        Assert.notNull(id, "The customer's id must not be null");
        return customers.get(id);
    }

    public Customer deleteCustomerByID(long id) {
        Assert.notNull(id, "The customer's id must not be null");
        return customers.remove(id);
    }

    public Customer modifyCustomer(ModifyCustomerRequest request){
        Customer myCustomer = customers.get(request.getId());
        if(!request.getName().isEmpty()){
            myCustomer.setName(request.getName());
        }else if(!request.getFirstName().isEmpty()){
            myCustomer.setFirstName(request.getFirstName());
        }if(!request.getLastName().isEmpty()){
            myCustomer.setLastName(request.getLastName());
        }if(!request.getEmail().isEmpty()){
            myCustomer.setEmail(request.getEmail());
        }
        customers.remove(request.getId());
        customers.put(request.getId(), myCustomer);
        return customers.get(request.getId());
    }
}
