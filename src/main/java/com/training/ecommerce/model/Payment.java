package com.training.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue
    private Long id;
    private Date paymentDate;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonBackReference
    public Customer getCustomer() {
        return customer;
    }
}
