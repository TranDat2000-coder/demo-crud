package com.example.demo_crud.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    private Long id;

    @NotNull(message = "nameProduct is mandatory!")
    @NotEmpty(message = "nameProduct is not empty!")
    private String nameProduct;

    @NotNull(message = "price is mandatory!")
    private BigDecimal price;

    @NotNull(message = "quantity is mandatory!")
    private int quantity;
}
