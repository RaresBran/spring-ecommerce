package com.training.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    @Id
    @GeneratedValue
    private Long id;
    private Integer quantity;
    private Double priceEach;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_code")
    private Product product;

    @JsonBackReference
    public Order getOrder() {
        return order;
    }

    @JsonBackReference
    public Product getProduct() {
        return product;
    }
}
