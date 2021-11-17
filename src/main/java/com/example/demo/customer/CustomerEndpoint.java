package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.CreateCustomerRequest;
import io.spring.guides.gs_producing_web_service.CustomerResponse;
import io.spring.guides.gs_producing_web_service.DeleteCustomerRequest;
import io.spring.guides.gs_producing_web_service.GetCustomerRequest;
import io.spring.guides.gs_producing_web_service.ModifyCustomerRequest;


@Endpoint
public class CustomerEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerEndpoint(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerRequest")
    @ResponsePayload
    public CustomerResponse getCustomer(@RequestPayload GetCustomerRequest request) {
        System.out.println("CustomerEndpoint.getCustomer()");
        CustomerResponse response = new CustomerResponse();
        response.setCustomer(customerRepository.findCustomerByID(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCustomerRequest")
    @ResponsePayload
    public CustomerResponse deleteCustomer(@RequestPayload DeleteCustomerRequest request) {
        System.out.println("CustomerEndpoint.deleteCustomer()");
        CustomerResponse response = new CustomerResponse();
        response.setCustomer(customerRepository.deleteCustomerByID(request.getId()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createCustomerRequest")
    @ResponsePayload
    public CustomerResponse createCustomer(@RequestPayload CreateCustomerRequest request) {
        System.out.println("CustomerEndpoint.createCustomer()");
        CustomerResponse response = new CustomerResponse();
        response.setCustomer(customerRepository.createCustomer(request.getName(),request.getFirstName(),request.getLastName(),request.getEmail()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "modifyCustomerRequest")
    @ResponsePayload
    public CustomerResponse modifyCustomer(@RequestPayload ModifyCustomerRequest request) {
        System.out.println("CustomerEndpoint.modifyCustomer()");
        CustomerResponse response = new CustomerResponse();
        response.setCustomer(customerRepository.modifyCustomer(request));
        return response;
    }
}
