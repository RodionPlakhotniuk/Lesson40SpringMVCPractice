package org.example.ordersystem.repository;

import org.example.ordersystem.model.Order;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OrderRepository {
    private final Map<Long, Order> orderMap = new HashMap<>();
    private long idCounter = 1;

    public Order addOrder(Order order) {
        order.setId(idCounter++);
        orderMap.put(order.getId(), order);
        return order;
    }

    public Optional<Order> getOrderById(Long id) {
        return Optional.ofNullable(orderMap.get(id));
    }

    public List<Order> getAllOrders() {
        return new ArrayList<>(orderMap.values());
    }
}
