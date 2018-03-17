package ca.skip.hackathon.entity;

import java.math.BigDecimal;

public class Product extends AbstractEntity {

    private int storeId;
    private String name;
    private String description;
    private BigDecimal price;

    public int getStoreId() {
        return this.storeId;
    }

    public void setStoreId(final int storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

}
