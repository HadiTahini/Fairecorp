package com.example.faircorp.Dto;

import com.example.faircorp.Pattern.Room;

public class RoomDto {
    
    Long id;
    String name;
    Integer floor;
    Double currentTemperature;
    Double targetTemperature;

    public RoomDto(Long id, String name, Integer floor, Double currentTemperature, Double targetTemperature) {
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.currentTemperature = currentTemperature;
        this.targetTemperature = targetTemperature;
    }

    public RoomDto(Room newRoom) {
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
}

