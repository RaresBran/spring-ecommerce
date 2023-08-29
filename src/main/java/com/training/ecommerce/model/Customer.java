package com.training.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String country;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;
    @OneToMany(mappedBy = "customer")
    private Set<Payment> payments;

    @JsonManagedReference
    public Set<Order> getOrders() {
        return orders;
    }

    @JsonManagedReference
    public Set<Payment> getPayments() {
        return payments;
    }
}
