package models; // Вказуємо, що цей клас в пакеті models

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products; // Список товарів у кошику

    // Конструктор класу
    public Cart() {
        this.products = new ArrayList<>();
    }

    // Метод для додавання товару до кошика
    public void addProduct(Product product) {
        products.add(product);
    }

    // Метод для видалення товару за об'єктом
    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Метод для видалення товару за ID
    public void removeProductById(int productId) {
        products.removeIf(product -> product.getId() == productId);
    }

    // Метод для отримання всіх товарів
    public List<Product> getProducts() {
        return new ArrayList<>(products); // Повертаємо копію списку
    }

    // Метод для очищення кошика
    public void clear() {
        products.clear();
    }

    // Метод для отримання загальної вартості товарів у кошику
    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Метод для пошуку товарів за назвою
    public List<Product> searchProductsByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    // Метод для пошуку товарів за категорією
    public List<Product> searchProductsByCategory(String categoryName) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().getName().toLowerCase().contains(categoryName.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Кошик містить:\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        sb.append("Загальна вартість: ").append(getTotalPrice());
        return sb.toString();
    }
}