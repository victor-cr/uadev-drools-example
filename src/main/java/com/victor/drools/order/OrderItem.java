package com.victor.drools.order;

/**
 * JavaDoc here
 *
 * @author Victor Polischuk
 * @since 15.04.12 22:58
 */
public class OrderItem {
    private final long orderId;
    private final String product;
    private int quantity;
    private long productId;

    public OrderItem(long orderId, String product) {
        this.orderId = orderId;
        this.product = product;
    }

    public long getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
