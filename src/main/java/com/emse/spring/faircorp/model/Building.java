package com.emse.spring.faircorp.model;


import javax.persistence.*;
import java.util.Set;

@Entity// (1)
@Table(name = "BUILDING")// (2)
public class Building {
    @Id // (3).
    @GeneratedValue

    private Long id;

    @Column(nullable = false, length = 255)// (4)
    private String name;

    @OneToMany(mappedBy = "building")  //Parent of rooms
    private Set<Room> rooms;

    public Building(){
    }

    public Building(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Set<Room> getRooms(){
        return rooms;
    }
}