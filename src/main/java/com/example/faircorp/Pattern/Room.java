package com.example.faircorp.Pattern;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Room")
public class Room {
    @Id
    private Long id;
    @Column(nullable = false,length = 255)
    private String name;
    @Column(nullable = false)
    private Integer floor;
    private Double currentTemperature;
    private Double targetTemperature;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Heater> heaters;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Window> windows;

    public Room() {

    }

    public Room(Long id, String name, Integer floor, Double currentTemperature, Double targetTemperature, Set<Heater> heaters, Set<Window> windows) {
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
        this.heaters = heaters;
        this.windows = windows;
    }

    public Room(String s1, int i) {
    }

    public Room(String name, Integer floor, Double currentTemperature, Double targetTemperature) {
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setCurrentTemp(Double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public void setTargetTemp(Double targetTemp) {
        this.targetTemperature = targetTemp;
    }

    public void setHeaters(Set<Heater> heaters) {
        this.heaters = heaters;
    }

    public void setWindows(Set<Window> windows) {
        this.windows = windows;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getFloor() {
        return floor;
    }

    public Double getCurrentTemp() {
        return currentTemperature;
    }

    public Double getTargetTemp() {
        return targetTemperature;
    }

    public Set<Heater> getHeaters() {
        return heaters;
    }

    public Set<Window> getWindows() {
        return windows;
    }
}
