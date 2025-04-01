package io.gffd94.spring_order;

import java.util.List;
import java.util.UUID;

// Entity
public class Order {
    // 식별자 UUID
    private final UUID orderId;
    private final UUID customerId;
    private final List<OrderItem> orderItems;
    // 할인에 의해 변경된 값 ( 특정 값인지 % 값인지 모르지만 의존도를 인터페이스로 줄여서 설정)
    private Voucher voucher;
    private OrderStatus orderStatus = OrderStatus.ACCEPTED;

    public Order(UUID orderId, UUID customerId, List<OrderItem> orderItems, Voucher voucher) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.voucher = voucher;

    }

    // 비즈니스 로직

    public long totalAmount() {
        // Stream.reduce() = 모든 요소를 합하는 함수
        var beforeDiscount = orderItems.stream().map(v -> v.getProductPrice() * v.getProductQuantity())
                .reduce(0L, Long::sum);
        return voucher.discount(beforeDiscount);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}


