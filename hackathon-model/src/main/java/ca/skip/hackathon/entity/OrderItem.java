package ca.skip.hackathon.entity;

import java.math.BigDecimal;

public class OrderItem extends AbstractEntity {

    private int orderId;
    private int productId;
    private BigDecimal price;
    private int quantity;

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(final int productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

}
