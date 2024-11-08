package models;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orders;

    public OrderHistory() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void showOrderHistory() {
        if (orders.isEmpty()) {
            System.out.println("Історія замовлень порожня.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }
}
