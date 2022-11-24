package com.example.customerservice.controllers;

import com.example.customerservice.entities.Customer;
import com.example.customerservice.services.CustomerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(value = {"", "/"})
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(value = {"/{customerId}", "/{customerId}/"})
    @Cacheable(value = "customer", key = "#customerId")
    @Retry(name = "customer-service", fallbackMethod = "getCustomerFallback")
    @CircuitBreaker(name = "customer-service", fallbackMethod = "getCustomerFallback")
    @RateLimiter(name = "customer-service")
    public Customer getCustomerById(@PathVariable long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping(value = {"", "/"})
    @Retry(name = "customer-service", fallbackMethod = "addCustomerFallback")
    @CircuitBreaker(name = "customer-service", fallbackMethod = "addCustomerFallback")
    @RateLimiter(name = "customer-service")
    public void addCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @GetMapping(value = {"/email/{email}", "/email/{email}/"})
    @Cacheable(value = "customer", key = "#email")
    public Customer getCustomerByEmail(@PathVariable String email) {
        return customerService.getCustomerByEmail(email);
    }

    @GetMapping(value = {"/phone/{phoneNumber}", "/phone/{phoneNumber}/"})
    @Cacheable(value = "customer", key = "#phoneNumber")
    public Customer getCustomerByPhoneNumber(@PathVariable String phoneNumber) {
        return customerService.getCustomerByPhoneNumber(phoneNumber);
    }

    public Customer getCustomerFallback(Exception e) {
        System.out.println("Fallback method called");
        return null;
    }

    public void addCustomerFallback(Exception e) {
        System.out.println("Fallback method called");
    }
}