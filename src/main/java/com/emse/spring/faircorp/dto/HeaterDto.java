package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.*;

// Dto pour le model heater

public class HeaterDto {

    private Long id;
    private String name;
    private HeaterStatus heaterStatus;
    private String roomName;
    private Long roomId;
    private  Long power;

    public HeaterDto(Room room){}
    public HeaterDto(){}
    public HeaterDto(Heater heater) {
        this.id = heater.getId();
        this.heaterStatus = heater.getHeaterStatus();
        this.name = heater.getName();
        this.power = heater.getPower();
        this.roomId = heater.getRoom().getId();

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

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getPower() { return power; }

    public void setPower(Long power) {this.power = power;}


}
