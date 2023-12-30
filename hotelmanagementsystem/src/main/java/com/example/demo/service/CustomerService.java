package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Customer;
import com.example.demo.exceptionhandling.CustomerNotFoundException;



public interface CustomerService {
	
	Customer createCustomer(Customer customer);

    Customer updateCustomer(int customerId, Customer updatedCustomer);

    void deleteCustomer(int customerId);

    Customer getCustomerById(int customerId);

    Iterable<Customer> getAllCustomers();
    
    Customer addRoomToCustomer(int customerId,int roomId);

}
