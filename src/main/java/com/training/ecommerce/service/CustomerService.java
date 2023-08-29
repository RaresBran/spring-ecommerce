package com.training.ecommerce.service;

import com.training.ecommerce.dto.CustomerDto;
import com.training.ecommerce.dto.PostalDetailsCustomerDto;
import com.training.ecommerce.model.Customer;
import com.training.ecommerce.model.Order;
import com.training.ecommerce.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer save(CustomerDto customerDto) {
        Customer newCustomer = modelMapper.map(customerDto, Customer.class);
        return customerRepository.save(newCustomer);
    }

    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    public PostalDetailsCustomerDto findAddressByUsername(String username) {
        Customer foundCustomer = findByUsername(username);
        return modelMapper.map(foundCustomer, PostalDetailsCustomerDto.class);
    }

    public Set<Order> findOrdersByUsername(String username) {
        return customerRepository.findByUsername(username).getOrders();
    }
}
