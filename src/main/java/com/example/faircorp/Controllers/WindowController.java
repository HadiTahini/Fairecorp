package com.example.faircorp.Controllers;

import com.example.faircorp.Dao.RoomDao;
import com.example.faircorp.Dao.WindowDao;
import com.example.faircorp.Dto.WindowDto;
import com.example.faircorp.Enums.WindowStatus;
import com.example.faircorp.Pattern.Room;
import com.example.faircorp.Pattern.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@Controller
@RequestMapping("/api/windows")
@Transactional
public class WindowController {

    @Autowired
    private final WindowDao windowDao;
    @Autowired
    private final RoomDao roomDao;

    public WindowController(WindowDao windowDao, RoomDao roomDao) {
        this.windowDao = windowDao;
        this.roomDao = roomDao;
    }

    @GetMapping("")
    public List<Window> list() {
        return windowDao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Window> get(@PathVariable Long id){
        return windowDao.findById(id);
    }
    @PostMapping()
    public WindowDto add(@RequestBody WindowDto windowDto) {
        Window newWindow=null;
        Room roomId = roomDao.getReferenceById(windowDto.getRoomId());
        if (windowDto.getId()==null) {
            newWindow = windowDao.save(new Window(windowDto.getName(), windowDto.getWindowStatus(),roomId));
        }
        else {
            newWindow = windowDao.getReferenceById(windowDto.getId());
            newWindow.setWindowStatus(windowDto.getWindowStatus());
        }
        return new WindowDto(newWindow);
    }
    @PutMapping("/{id}/reverse-window-status")
    public WindowDto reverseWindowStatus(@PathVariable Long id){
        Window window = windowDao.findById(id).orElseThrow();
        window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED :WindowStatus.OPEN);
        return new WindowDto(window);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        windowDao.deleteById(id);
    }
}