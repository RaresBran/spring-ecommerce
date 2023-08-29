package com.training.ecommerce.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostalDetailsCustomerDto {
    private String phone;
    private String address;
    private String city;
}
