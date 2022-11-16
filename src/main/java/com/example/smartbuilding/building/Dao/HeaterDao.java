package com.example.smartbuilding.building.Dao;

import com.example.smartbuilding.building.Pattern.Heater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeaterDao extends JpaRepository<Heater,Long>, HeaterDaoCustom {
}

