package com.example.orderservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    @NotNull(message = "Product code không được để trống")
    private String code;

    @NotNull(message = "Quantity không được để trống")
    @Positive(message = "Quantity phải lớn hơn 0")
    private Integer quantity;
}