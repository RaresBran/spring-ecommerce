package com.training.ecommerce.controller;

import com.training.ecommerce.dto.CustomerDto;
import com.training.ecommerce.dto.PostalDetailsCustomerDto;
import com.training.ecommerce.model.Customer;
import com.training.ecommerce.model.Order;
import com.training.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{username}")
    public ResponseEntity<Customer> getByUsername(@PathVariable String username) {
        return ResponseEntity.ok(customerService.findByUsername(username));
    }

    @GetMapping("/{username}/address")
    public ResponseEntity<PostalDetailsCustomerDto> getAddressByUsername(@PathVariable String username) {
        return ResponseEntity.ok(customerService.findAddressByUsername(username));
    }

    @GetMapping("/{username}/orders")
    public ResponseEntity<Set<Order>> getOrdersByUsername(@PathVariable String username) {
        return ResponseEntity.ok(customerService.findOrdersByUsername(username));
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody @Validated CustomerDto customerDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerService.save(customerDto));
    }
}
