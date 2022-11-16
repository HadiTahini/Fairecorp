package com.example.faircorp.Controllers;

import com.example.faircorp.Dao.HeaterDao;
import com.example.faircorp.Dao.RoomDao;
import com.example.faircorp.Dto.HeaterDto;
import com.example.faircorp.Enums.HeaterStatus;
import com.example.faircorp.Pattern.Heater;
import com.example.faircorp.Pattern.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/heater")
@Transactional
public class HeaterController {

    @Autowired
    private final HeaterDao heaterDao;
    @Autowired
    private final RoomDao roomDao;

    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) {
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping("")
    public List<Heater> list() {
        return heaterDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Heater> get(@PathVariable Long id){
        return heaterDao.findById(id);
    }

    @PostMapping()
    public HeaterDto add(@RequestBody HeaterDto heaterDto) {
        Heater newHeater=null;
        Room roomId = roomDao.getReferenceById(heaterDto.getRoomId());
        if (heaterDto.getId()==null) {
            newHeater = heaterDao.save(new Heater(roomId, heaterDto.getName(), heaterDto.getHeaterStatus(),heaterDto.getPower()));
        }
        return new HeaterDto(newHeater);
    }
    @PutMapping("/{id}/reverse-heater-status")
    public HeaterDto reverseHeaterStatus(@PathVariable Long id){
        Heater heater = heaterDao.findById(id).orElseThrow();
        heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.OFF ? HeaterStatus.ON :HeaterStatus.OFF);
        return new HeaterDto(heater);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }
}
