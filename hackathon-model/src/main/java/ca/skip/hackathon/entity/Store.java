package ca.skip.hackathon.entity;

public class Store extends AbstractEntity {

    private String name;
    private String address;
    private int cousineId;

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
