package com.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderHistory {
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void showOrderHistory() {
        if (orders.isEmpty()) {
            System.out.println("Історія замовлень порожня.");
        } else {
            orders.forEach(System.out::println);
        }
    }
}
