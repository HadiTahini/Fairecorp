package com.example.faircorp.Pattern;

import com.example.faircorp.Enums.HeaterStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Heater")
public class Heater {
    @Id
    private Long id;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private HeaterStatus heaterStatus;
    @Column(nullable = false, length = 255)
    private String name;
    @Column(nullable = true)
    private Long power;
    @ManyToOne
    @JsonBackReference
    private Room room;

    public Heater() {
    }

    public Heater(Long id, String name, HeaterStatus heaterStatus, Long power, Room room) {
        this.id = id;
        this.name = name;
        this.heaterStatus = heaterStatus;
        this.power = power;
        this.room = room;
    }

    public Heater(Room room, String name, HeaterStatus heaterStatus) {
    }

    public Heater(Room roomId, String name, HeaterStatus heaterStatus, Long power) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeaterStatus getHeaterStatus() {
        return heaterStatus;
    }

    public void setHeaterStatus(HeaterStatus heaterStatus) {
        this.heaterStatus = heaterStatus;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
