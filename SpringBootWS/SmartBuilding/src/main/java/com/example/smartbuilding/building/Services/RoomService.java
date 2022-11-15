package com.example.smartbuilding.building.Services;

import com.example.smartbuilding.building.Dao.RoomDao;
import com.example.smartbuilding.building.Pattern.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoomService {
        @Autowired
        private RoomDao roomDao;
        public List<Room> listAllRooms() {
            return roomDao.findAll();
        }

        public void saveRoom(Room room) {
            roomDao.save(room);
        }

        public Room getRoom(Long id) {
            return roomDao.findById(id).get();
        }

        public void deleteRoom(Long id) {
            roomDao.deleteById(id);
        }

}
