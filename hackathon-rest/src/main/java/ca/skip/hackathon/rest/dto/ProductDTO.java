package ca.skip.hackathon.rest.dto;

import java.math.BigDecimal;

import ca.skip.hackathon.entity.Product;

public class ProductDTO {

    private int id;
    private int storeId;
    private String name;
    private String description;
    private BigDecimal price;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.storeId = product.getStoreId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

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
        return this.price;
    }

    public void setPrice(final BigDecimal price) {
        this.price = price;
    }

}
