package com.example.smartbuilding.building.Dao;

import com.example.smartbuilding.building.Pattern.Heater;

import java.util.List;

public interface HeaterDaoCustom {
    List<Heater> findRoomWithOnHeater(Long id);

}
