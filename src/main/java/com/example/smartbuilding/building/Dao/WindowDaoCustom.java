package com.example.smartbuilding.building.Dao;

import com.example.smartbuilding.building.Pattern.Window;

import java.util.List;

public interface WindowDaoCustom {
    List<Window> findRoomOpenWindows(Long id);

    List<Window> findRWindowByRoomName(String name);

    List<Window> deleteAllWindowInRoom(Long id);
}
