package com.example.faircorp.Controllers;

import com.example.faircorp.Dao.RoomDao;
import com.example.faircorp.Dto.HeaterDto;
import com.example.faircorp.Dto.RoomDto;
import com.example.faircorp.Dto.WindowDto;
import com.example.faircorp.Enums.HeaterStatus;
import com.example.faircorp.Enums.WindowStatus;
import com.example.faircorp.Pattern.Heater;
import com.example.faircorp.Pattern.Room;
import com.example.faircorp.Pattern.Window;
import com.example.faircorp.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@RestController
@RequestMapping("/api/rooms")
@Transactional
public class RoomController {

    @Autowired
    RoomService roomService;
    @Autowired
    RoomDao roomDao;
    public RoomController(RoomDao roomDao){
        this.roomDao = roomDao;
    }
    @GetMapping("")
    public List<Room> list() {
        return roomService.listAllRooms();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Room> get(@PathVariable Long id) {
        try {
            Room room = roomService.getRoom(id);
            return new ResponseEntity<Room>(room, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping()
    public RoomDto add(@RequestBody RoomDto roomDto) {
        Room newRoom=null;
        if (roomDto.getId()==null) {
            newRoom = roomDao.save(new Room(roomDto.getName(), roomDto.getFloor(),
                    roomDto.getCurrentTemperature(), roomDto.getTargetTemperature()));
        }
        return new RoomDto(newRoom);
    }
    @PutMapping("/{id}/reverse-heater-status")
    public List<HeaterDto> reverseHeaterStatus(@PathVariable Long id){
        Room room = roomDao.findById(id).orElseThrow();
        Set<Heater> heaters = room.getHeaters();
        List<HeaterDto> result = new ArrayList<>();
        for(Heater heater : heaters){
            heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF :HeaterStatus.ON);
            result.add(new HeaterDto(heater));
        }
        return result;
    }
    @PutMapping("/{id}/reverse-window-status")
    public List<WindowDto> reverseWindowStatus(@PathVariable Long id){
        Room room = roomDao.findById(id).orElseThrow();
        Set<Window> windows = room.getWindows();
        List<WindowDto> result = new ArrayList<>();
        for(Window window : windows){
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.CLOSED ? WindowStatus.OPEN :WindowStatus.CLOSED);
            result.add(new WindowDto(window));
        }
        return result;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        roomDao.deleteById(id);
    }
}
