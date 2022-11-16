package com.example.faircorp.Dao;

import com.example.faircorp.Pattern.Room;
import java.util.List;

public interface RoomDaoCustom {
    List<Room> findRoomByName(String name);
    List<Room> findRoomsWithOpenWindow(String status);

}
