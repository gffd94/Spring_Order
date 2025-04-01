package io.gffd94.spring_order.repository;

import io.gffd94.spring_order.order.Order;

public interface OrderRepository {
    void insert(Order order);
}
