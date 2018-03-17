package ca.skip.hackathon.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Order extends AbstractEntity {

    private ZonedDateTime date;
    private int customerId;
    private String deliveryAddress;
    private String contact;
    private int storeId;
    private BigDecimal total;
    private String status;
    private ZonedDateTime lastUpdate;

    public ZonedDateTime getDate() {
        return this.date;
    }

    public void setDate(final ZonedDateTime date) {
        this.date = date;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final int customerId) {
        this.customerId = customerId;
    }

    public String getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(final String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(final String contact) {
        this.contact = contact;
    }

    public int getStoreId() {
        return this.storeId;
    }

    public void setStoreId(final int storeId) {
        this.storeId = storeId;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(final BigDecimal total) {
        this.total = total;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public ZonedDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(final ZonedDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
