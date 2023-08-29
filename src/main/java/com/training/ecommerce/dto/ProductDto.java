package com.training.ecommerce.dto;
import com.training.ecommerce.model.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private String description;
    private Short stock;
    private Double price;
    private Set<OrderDetailsDto> orderDetailsDtos;
}
