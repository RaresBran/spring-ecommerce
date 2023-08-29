package com.training.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private Date orderDate;
    private Date shippedDate;
    private String status;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private Set<OrderDetails> orderDetails;

    @JsonBackReference
    public Customer getCustomer() {
        return customer;
    }

    @JsonManagedReference
    public Set<OrderDetails> getOrderDetails() {
        return orderDetails;
    }
}
