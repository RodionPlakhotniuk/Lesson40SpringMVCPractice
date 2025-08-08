package org.example.ordersystem.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private LocalDateTime creationDate;
    private double totalCost;
    private List<Product> products;

    public Order() {
    }

    public Order(Long id, LocalDateTime creationDate, List<Product> products) {
        this.id = id;
        this.creationDate = creationDate;
        this.products = products;
        this.totalCost = calculateTotalCost(products);
    }

    private double calculateTotalCost(List<Product> products) {
        return products.stream().mapToDouble(Product::getCost).sum();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        this.totalCost = calculateTotalCost(products);
    }
}
