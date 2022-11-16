package com.example.faircorp.Pattern;

import com.example.faircorp.Enums.WindowStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "RWindow")
public class Window {
    @Id
    private Long id;
    @Column(nullable = false, length = 255)
    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WindowStatus windowStatus;
    @ManyToOne
    @JsonBackReference
    private Room room;

    public Window() {
    }

    public Window(Long id, String name, WindowStatus windowStatus, Room room) {
        this.id = id;
        this.name = name;
        this.windowStatus = windowStatus;
        this.room = room;
    }
    
    public Window(String name, WindowStatus windowStatus, Room roomId) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WindowStatus getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(WindowStatus windowStatus) {
        this.windowStatus = windowStatus;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
