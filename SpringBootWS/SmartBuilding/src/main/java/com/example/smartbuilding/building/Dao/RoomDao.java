package com.example.smartbuilding.building.Dao;

import com.example.smartbuilding.building.Pattern.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room,Long>, RoomDaoCustom {
}
