package models;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private List<Order> orders; // Список всіх замовлень

    public OrderHistory() {
        this.orders = new ArrayList<>();
    }

    // Додає замовлення до історії
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Показує всі замовлення
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
