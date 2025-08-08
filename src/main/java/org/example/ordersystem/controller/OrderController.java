package org.example.ordersystem.controller;

import org.example.ordersystem.model.Order;
import org.example.ordersystem.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return repository.addOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return repository.getOrderById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return repository.getAllOrders();
    }
}
