package com.example.smartbuilding.building.Dao;

import com.example.smartbuilding.building.Pattern.Window;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WindowDao extends JpaRepository<Window,Long>, WindowDaoCustom {


}
