package com.example.faircorp.Dao;

import com.example.faircorp.Pattern.Heater;

import java.util.List;

public interface HeaterDaoCustom {
    List<Heater> findRoomWithOnHeater(Long id);

}
