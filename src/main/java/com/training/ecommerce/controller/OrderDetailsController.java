package com.training.ecommerce.controller;

import com.training.ecommerce.dto.OrderDetailsDto;
import com.training.ecommerce.model.OrderDetails;
import com.training.ecommerce.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping("/order-details")
    public ResponseEntity<List<OrderDetails>> getAllOrders() {
        return ResponseEntity.ok(orderDetailsService.findAll());
    }

    @PostMapping("/order-details")
    public ResponseEntity<List<OrderDetails>> saveAll(@RequestBody @Validated List<OrderDetailsDto> orderDetailsDtoList) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderDetailsService.saveAll(orderDetailsDtoList));
    }
}
