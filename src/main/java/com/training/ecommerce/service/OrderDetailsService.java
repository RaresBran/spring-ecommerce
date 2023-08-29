package com.training.ecommerce.service;

import com.training.ecommerce.dto.OrderDetailsDto;
import com.training.ecommerce.exception.InvalidDataException;
import com.training.ecommerce.model.OrderDetails;
import com.training.ecommerce.model.Product;
import com.training.ecommerce.repository.OrderDetailsRepository;
import com.training.ecommerce.repository.OrderRepository;
import com.training.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public List<OrderDetails> findAll() {
        return orderDetailsRepository.findAll();
    }

    public OrderDetails save(OrderDetailsDto orderDetailsDto) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setQuantity(orderDetailsDto.getQuantity());
        Product newProduct = productRepository
                .findById(orderDetailsDto.getProductCode())
                .orElseThrow(InvalidDataException::new);
        orderDetails.setProduct(newProduct);
        orderDetails.setPriceEach(newProduct.getPrice());
        orderDetails.setOrder(orderRepository
                .findById(orderDetailsDto.getOrderId())
                .orElseThrow(InvalidDataException::new));
        return orderDetails;
    }

    public List<OrderDetails> saveAll(List<OrderDetailsDto> orderDetailsDtoList) throws InvalidDataException {
        List<OrderDetails> newOrderDetailsList = orderDetailsDtoList
                .stream()
                .map(orderDetailsDto -> {
                    OrderDetails orderDetails = new OrderDetails();
                    orderDetails.setQuantity(orderDetailsDto.getQuantity());
                    Product newProduct = productRepository
                            .findById(orderDetailsDto.getProductCode())
                            .orElseThrow(InvalidDataException::new);
                    orderDetails.setProduct(newProduct);
                    orderDetails.setPriceEach(newProduct.getPrice());
                    orderDetails.setOrder(orderRepository
                            .findById(orderDetailsDto.getOrderId())
                            .orElseThrow(InvalidDataException::new));
                    return orderDetails;
                })
                .toList();
        return orderDetailsRepository.saveAll(newOrderDetailsList);
    }
}
