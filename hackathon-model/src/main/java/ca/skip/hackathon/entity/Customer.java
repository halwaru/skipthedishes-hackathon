package ca.skip.hackathon.entity;

import java.time.ZonedDateTime;

public class Customer extends AbstractEntity {

    private String email;
    private String name;
    private String address;
    private ZonedDateTime creation;
    private String password;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
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

    public ZonedDateTime getCreation() {
        return this.creation;
    }

    public void setCreation(final ZonedDateTime creation) {
        this.creation = creation;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

}
