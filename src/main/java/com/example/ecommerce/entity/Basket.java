package com.example.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Basket {
    public List<BasketProduct> basketProducts = new ArrayList<>();

    public Basket(Basket basket) {
        this.basketProducts = basket.basketProducts;
    }

    public void incrementBasketProductById(String basketProductId) {
        for (BasketProduct basketProduct : basketProducts) {
            if (basketProduct.getId().equals(UUID.fromString(basketProductId))) {
                basketProduct.setAmount(basketProduct.getAmount() + 1);
            }
        }
    }

    public void decrementBasketProductById(String basketProductId) {
        for (BasketProduct basketProduct : basketProducts) {
            if (basketProduct.getId().equals(UUID.fromString(basketProductId))) {
                if (basketProduct.getAmount() <= 0) {
                    return;
                } else {
                    basketProduct.setAmount(basketProduct.getAmount() - 1);
                }
            }
        }
    }
}
