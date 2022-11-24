package com.example.customerservice.services;

import com.example.customerservice.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(long id);

    Customer getCustomerByEmail(String email);

    void createCustomer(Customer customer);

    Customer getCustomerByPhoneNumber(String phoneNumber);
}
