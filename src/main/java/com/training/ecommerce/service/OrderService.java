package com.training.ecommerce.service;

import com.training.ecommerce.dto.OrderDetailsDto;
import com.training.ecommerce.dto.OrderDto;
import com.training.ecommerce.model.Customer;
import com.training.ecommerce.model.Order;
import com.training.ecommerce.model.OrderDetails;
import com.training.ecommerce.model.Product;
import com.training.ecommerce.repository.CustomerRepository;
import com.training.ecommerce.repository.OrderRepository;
import com.training.ecommerce.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OrderService(OrderRepository orderRepository,
                        CustomerRepository customerRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order save(OrderDto orderDto, String username) {
        Order newOrder = modelMapper.map(orderDto, Order.class);
        return orderRepository.save(newOrder);
    }

    public List<Order> saveAll(List<OrderDto> orderDtoList, String username) {
        Customer customer = customerRepository.findByUsername(username);
        List<Order> newOrders = orderDtoList
                .stream()
                .map(orderDto -> {
                    Order order = modelMapper.map(orderDto, Order.class);
                    order.setCustomer(customer);
                    return order;
                })
                .toList();
        return orderRepository.saveAll(newOrders);
    }
}
