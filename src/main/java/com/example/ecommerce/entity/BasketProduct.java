package com.example.ecommerce.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketProduct {
    private int productId;
    private int amount;
    private final UUID id = UUID.randomUUID();
}
