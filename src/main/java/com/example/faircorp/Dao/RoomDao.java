package com.example.faircorp.Dao;

import com.example.faircorp.Pattern.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room,Long>, RoomDaoCustom {

    @Override
    Room getReferenceById(Long aLong);
}
