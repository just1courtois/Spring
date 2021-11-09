package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Building;
import com.emse.spring.faircorp.model.Room;

public class BuildingDto {

    private Long id;
    private String name;

    public BuildingDto(){}

    public BuildingDto(Building building) {
        this.id = building.getId();
        this.name = building.getName();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }


}
