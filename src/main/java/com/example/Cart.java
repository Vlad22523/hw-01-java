package com.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProductById(int productId) {
        products.removeIf(product -> product.getId() == productId);
    }

    public void clear() {
        products.clear();
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public List<Product> searchProductsByName(String name) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public List<Product> searchProductsByCategory(String categoryName) {
        return products.stream()
                .filter(product -> product.getCategory().getName().toLowerCase().contains(categoryName.toLowerCase()))
                .toList();
    }
}
