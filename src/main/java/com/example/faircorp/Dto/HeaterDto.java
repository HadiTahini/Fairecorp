package com.example.faircorp.Dto;

import com.example.faircorp.Enums.HeaterStatus;
import com.example.faircorp.Pattern.Heater;

public class HeaterDto {
    Long id;
    String name;
    HeaterStatus heaterStatus;
    Long power;
    Long roomId;

    public HeaterDto(Long id, String name, HeaterStatus heaterStatus, Long power, Long roomId) {
        this.id = id;
        this.name = name;
        this.heaterStatus = heaterStatus;
        this.power = power;
        this.roomId = roomId;
    }

    public HeaterDto(Heater heater) {
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

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

}
