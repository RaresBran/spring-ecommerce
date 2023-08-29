package com.training.ecommerce.dto;

import com.training.ecommerce.model.Order;
import com.training.ecommerce.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String username;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private Set<OrderDto> orders;
    private Set<PaymentDto> payments;
}
