package io.gffd94.spring_order;

import java.util.UUID;

public class OrderItem {
    private final UUID productId;
    private final long productPrice;
    private final long productQuantity;

    public OrderItem(UUID productId, long productPrice, long productQuantity) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public UUID getProductId() {
        return productId;
    }

    public long getProductPrice() {
        return productPrice;
    }

    public long getProductQuantity() {
        return productQuantity;
    }
}
