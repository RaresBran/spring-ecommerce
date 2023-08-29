package com.training.ecommerce.controller;

import com.training.ecommerce.dto.ProductDto;
import com.training.ecommerce.model.Product;
import com.training.ecommerce.service.ProductService;
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
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping("/product")
    public ResponseEntity<Product> save(@RequestBody @Validated ProductDto productDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.save(productDto));
    }

    @PostMapping("/products")
    public ResponseEntity<List<Product>> saveAll(@RequestBody @Validated List<ProductDto> productDtoList) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.saveAll(productDtoList));
    }
}
