package com.example.faircorp.Dao;

import com.example.faircorp.Pattern.Window;

import java.util.List;

public interface WindowDaoCustom {
    List<Window> findRoomOpenWindows(Long id);

    List<Window> findRWindowByRoomName(String name);

    List<Window> deleteAllWindowInRoom(Long id);
}
