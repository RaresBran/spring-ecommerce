package com.training.ecommerce.controller;
import com.training.ecommerce.dto.OrderDetailsDto;
import com.training.ecommerce.dto.OrderDto;
import com.training.ecommerce.model.Order;
import com.training.ecommerce.service.OrderService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @PostMapping("/{username}")
    public ResponseEntity<List<Order>> saveAll(@RequestBody @Validated List<OrderDto> orderDtoList,
                                               @PathVariable String username) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderService.saveAll(orderDtoList, username));
    }
}
