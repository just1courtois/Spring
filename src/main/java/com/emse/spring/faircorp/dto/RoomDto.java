package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.*;

import java.util.List;

public class RoomDto {

    private Long id;
    private String name;
    private Double currentTemperature;
    private Double targetTemperature;
    private Integer floor;
    private Long buildingId;
    private List<WindowDto> windows;
    private List<HeaterDto> heaters;



    public RoomDto(){}

    public RoomDto(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.currentTemperature = room.getCurrentTemperature();
        this.targetTemperature = room.getTargetTemperature();
        this.floor = room.getFloor();
        this.buildingId = room.getBuilding().getId();
    }



    public RoomDto(Building building){}


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


    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }
    public Long getBuildingId() { return buildingId; }
    public void setBuidldingId() {this.buildingId= buildingId;}

}
