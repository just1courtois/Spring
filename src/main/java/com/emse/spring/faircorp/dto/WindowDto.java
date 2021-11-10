package com.emse.spring.faircorp.dto;

import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

public class WindowDto {
    private Long id;
    private String name;
    private WindowStatus windowStatus;
    private String roomName;
    private Long roomId;
    private Double roomCurrentTemperature;
    private Double roomTargetTemperature;

    public WindowDto() {
    }

    public WindowDto(Window window) {
        this.id = window.getId();
        this.name = window.getName();
        this.windowStatus = window.getWindowStatus();
        this.roomName = window.getRoom().getName();
        this.roomId = window.getRoom().getId();
        this.roomCurrentTemperature = window.getRoom().getCurrentTemperature();
        this.roomTargetTemperature = window.getRoom().getTargetTemperature();
    }

    public WindowDto(Room room) {
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

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Double getRoomTargetTemperature () {
        return roomTargetTemperature ;
    }

    public void setRoomTargetTemperature(Double roomTargetTemperature) {
        this.roomTargetTemperature = roomTargetTemperature;
    }

    public Double getRoomCurrentTemperature () {
        return roomCurrentTemperature ;
    }

    public void setRoomCurrentTemperature(Double roomCurrentTemperature) {
        this.roomCurrentTemperature = roomCurrentTemperature;
    }
    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }


}