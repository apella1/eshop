package me.apella.eshop.service.impl;

import me.apella.eshop.model.Customer;
import me.apella.eshop.repository.CustomerRepository;
import me.apella.eshop.service.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public boolean updateCustomerById(UUID customerId, Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setEmail(updatedCustomer.getEmail());
            customer.setName(updatedCustomer.getName());
            customer.setPassword(updatedCustomer.getPassword());
            customer.setShippingAddress(updatedCustomer.getShippingAddress());
            customerRepository.save(customer);
            return true;
        }

        return false;
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public boolean deleteCustomerById(UUID customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            customerRepository.deleteById(customerId);
            return true;
        }
        return false;
    }
}
