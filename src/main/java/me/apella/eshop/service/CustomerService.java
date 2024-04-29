package me.apella.eshop.service;

import me.apella.eshop.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> findAll();

    void createCustomer(Customer customer);

    boolean updateCustomerById(UUID customerId, Customer updatedCustomer);

    Customer getCustomerById(UUID customerId);

    boolean deleteCustomerById(UUID customerId);
}
