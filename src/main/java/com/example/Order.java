package com.example;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private List<Product> products;
    private double totalPrice;
    private String status;

    public Order(Cart cart) {
        this.products = List.copyOf(cart.getProducts());
        this.totalPrice = cart.getTotalPrice();
        this.status = "Нове";
    }
}
