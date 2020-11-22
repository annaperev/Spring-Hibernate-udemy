package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // autowire the CustomerService
    @Autowired
    private CustomerService customerService;

    // add mapping for GET/customers
    @GetMapping("/customers")
    public List<Customer> getCustomers(){

        return customerService.getCustomers();
    }

    // add mapping for GET/customers/{customerId}
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){

        Customer customer = customerService.getCustomer(customerId);

        if (customer == null){
            throw new CustomerNotFoundException("Customer is not found - " + customerId);
        }

        return customer;
    }

    // add mapping for POST/customers
    @PostMapping("/customers")
    public Customer setCustomer(@RequestBody Customer customer){

        // in case the pass an id in JSON we set id to 0
        // this is force a save a new item instead of update
        customer.setId(0);

        customerService.saveCustomer(customer);

        return customer;
    }

    // add mapping for PUT/customers
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){

        customerService.saveCustomer(customer);

        return customer;
    }

    // add mapping for DELETE/customers
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){

        if(customerService.getCustomer(customerId) == null){
            throw new CustomerNotFoundException("Customer is not found " + customerId);
        }
        customerService.deleteCustomer(customerId);

        return "Delete customer id - " + customerId;
    }

}
