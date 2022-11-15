package com.example.smartbuilding.building.Dao;

import com.example.smartbuilding.building.Pattern.Room;

import java.util.List;

public interface RoomDaoCustom {
    List<Room> findRoomByName(String name);
    List<Room> findRoomsWithOpenWindow(String status);

}
