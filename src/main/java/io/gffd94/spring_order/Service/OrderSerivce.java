package io.gffd94.spring_order.Service;

import io.gffd94.spring_order.order.Order;
import io.gffd94.spring_order.order.OrderItem;
import io.gffd94.spring_order.repository.OrderRepository;

import java.util.List;
import java.util.UUID;

public class OrderSerivce {
    private final OrderRepository orderRepository;
    private final VoucherService voucherService;

    public OrderSerivce(OrderRepository orderRepository, VoucherService voucherService) {
        this.orderRepository = orderRepository;
        this.voucherService = voucherService;
    }

    // voucherId 가 있는 경우
    public Order createOrder(UUID customerId, List<OrderItem> orderItems, UUID voucherId) {
        var voucher = voucherService.getVoucher(voucherId);
        var order = new Order(UUID.randomUUID(), customerId, orderItems, voucher);
        orderRepository.insert(order);
        voucherService.useVoucher(voucher);
        return order;
    }

    // voucherId 가 없는 경우
    public Order createOrder(UUID customerId, List<OrderItem> orderItems) {

        var order = new Order(UUID.randomUUID(), customerId, orderItems);
        orderRepository.insert(order);
        return order;
    }
}

