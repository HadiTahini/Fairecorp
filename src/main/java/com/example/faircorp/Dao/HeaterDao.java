package com.example.faircorp.Dao;

import com.example.faircorp.Pattern.Heater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeaterDao extends JpaRepository<Heater,Long>, HeaterDaoCustom {
}

