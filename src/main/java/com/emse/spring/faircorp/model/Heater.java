package com.emse.spring.faircorp.model;


import javax.persistence.*;

// Creation du model heater

@Entity

public class Heater {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column
    private Long power;

    @ManyToOne
    private Room room;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private HeaterStatus heaterStatus;

    public Heater(Long id, String name, Room room, HeaterStatus heaterStatus, Long power) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.heaterStatus = heaterStatus;
        this.power =power;

    }

    public Heater(String name, Room room, HeaterStatus heaterStatus, Long power) {
        this.name = name;
        this.room = room;
        this.heaterStatus = heaterStatus;
        this.power = power;
    }

    public Heater(){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom(){return room;}

    public void setRoom(Room room) {this.room = room;}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus =heaterStatus;
    }

    public Long getPower() {
        return this.power;
    }

    public void setPower(Long id) {
        this.power = power;
    }

}
