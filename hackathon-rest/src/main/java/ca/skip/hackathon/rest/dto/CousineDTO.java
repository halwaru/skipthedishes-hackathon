package ca.skip.hackathon.rest.dto;

import ca.skip.hackathon.entity.Cousine;

public class CousineDTO {

    private int id;
    private String name;

    public CousineDTO(Cousine entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public int getId() {
        return id;
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

}
