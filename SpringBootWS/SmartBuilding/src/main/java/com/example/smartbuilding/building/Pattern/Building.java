package com.example.smartbuilding.building.Pattern;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity()
public class Building {
    @Id
    private Long id;
    private String name;
    private Double temperature;
    @OneToMany
    private Set<Room> rooms;
}
