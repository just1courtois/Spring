package com.emse.spring.faircorp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private String name;

    @Column
    private Double currentTemperature;

    @Column
    private Double targetTemperature;

    @OneToMany(mappedBy = "room")
    private Set<Heater> heater;

    @OneToMany(mappedBy = "room")
    private Set<Window> windows;

    public Room( Integer floor, String name,Building building) {
        this.floor = floor;
        this.name = name;
        this.building = building;
    }
    public Room(){}

    public Room(Integer floor, String name, Building building, Double currentTemperature, Double targetTemperature) {
        this.floor = floor;
        this.name = name;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
        this.building = building;
    }

    public Double getCurrentTemperature() {
        return currentTemperature;
    }
    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public String getName() {
        return name;
    }

    public Set<Window> getWindows() { return windows;}

    public Long getId() {
        return this.id;
    }



    @ManyToOne //child of Building
    private Building building ;//define building

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }
    
    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Integer getFloor() {
        return floor;
    }
}
