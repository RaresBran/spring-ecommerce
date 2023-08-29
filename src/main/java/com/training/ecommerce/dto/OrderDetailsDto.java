package com.training.ecommerce.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDto {
    private Integer quantity;
    private Long orderId;
    private String productCode;
}
