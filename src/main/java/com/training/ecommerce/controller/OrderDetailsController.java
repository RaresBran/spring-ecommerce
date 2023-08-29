package com.training.ecommerce.controller;

import com.training.ecommerce.dto.OrderDetailsDto;
import com.training.ecommerce.model.OrderDetails;
import com.training.ecommerce.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-details")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    @Autowired
    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDetails>> getAllOrders() {
        return ResponseEntity.ok(orderDetailsService.findAll());
    }

    @PostMapping
    public ResponseEntity<List<OrderDetails>> saveAll(@RequestBody @Validated List<OrderDetailsDto> orderDetailsDtoList) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderDetailsService.saveAll(orderDetailsDtoList));
    }
}
