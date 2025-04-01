package io.gffd94.spring_order;

import io.gffd94.spring_order.context.OrderContext;
import io.gffd94.spring_order.order.Order;
import io.gffd94.spring_order.order.OrderItem;
import io.gffd94.spring_order.voucher.FixedAmountVoucher;
import org.springframework.util.Assert;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.UUID;

public class OrderTester {
    public static void main(String[] args) {
        var customerId = UUID.randomUUID();
        var orderContext = new OrderContext();
        var orderService = orderContext.orderSerivce();
        var orderItems = new ArrayList<OrderItem>() {{
            add(new OrderItem(UUID.randomUUID(), 100L, 1));
        }};
        var order = orderService.createOrder(customerId,orderItems);
        Assert.isTrue(order.totalAmount() == 100L, MessageFormat.format("total amount is not {100}", order.totalAmount()));
    }
}
