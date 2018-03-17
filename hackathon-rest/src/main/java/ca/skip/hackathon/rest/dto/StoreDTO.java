package ca.skip.hackathon.rest.dto;

import ca.skip.hackathon.entity.Store;

public class StoreDTO {

    private int id;
    private String name;
    private String address;
    private int cousineId;

    public StoreDTO(Store store) {
        this.id = store.getId();
        this.name = store.getName();
        this.address = store.getAddress();
        this.cousineId = store.getCousineId();
    }

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public int getCousineId() {
        return this.cousineId;
    }

    public void setCousineId(final int cousineId) {
        this.cousineId = cousineId;
    }

}
