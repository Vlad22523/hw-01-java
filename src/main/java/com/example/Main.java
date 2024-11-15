package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");

        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        Cart cart = new Cart();
        OrderHistory orderHistory = new OrderHistory();

        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Видалити товар з кошика");
            System.out.println("4 - Переглянути кошик");
            System.out.println("5 - Пошук товарів за назвою");
            System.out.println("6 - Пошук товарів за категорією");
            System.out.println("7 - Оформити замовлення");
            System.out.println("8 - Переглянути історію замовлень");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                }
                case 2 -> {
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    if (id == 1) cart.addProduct(product1);
                    else if (id == 2) cart.addProduct(product2);
                    else if (id == 3) cart.addProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                }
                case 3 -> {
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int removeId = scanner.nextInt();
                    cart.removeProductById(removeId);
                }
                case 4 -> System.out.println(cart);
                case 5 -> {
                    System.out.println("Введіть назву товару для пошуку:");
                    scanner.nextLine();
                    String searchName = scanner.nextLine();
                    cart.searchProductsByName(searchName).forEach(System.out::println);
                }
                case 6 -> {
                    System.out.println("Введіть категорію товару для пошуку:");
                    scanner.nextLine();
                    String searchCategory = scanner.nextLine();
                    cart.searchProductsByCategory(searchCategory).forEach(System.out::println);
                }
                case 7 -> {
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній.");
                    } else {
                        Order order = new Order(cart);
                        orderHistory.addOrder(order);
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear();
                    }
                }
                case 8 -> orderHistory.showOrderHistory();
                case 0 -> {
                    System.out.println("Дякуємо за використання!");
                    return;
                }
                default -> System.out.println("Невідома опція.");
            }
        }
    }
}
