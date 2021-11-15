package com.emse.spring.faircorp.controller;


import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController // (1)
@RequestMapping("/api/rooms") // (2)
@Transactional // (3)
public class RoomController {

    private final RoomDao roomDao;
    private final BuildingDao buildingDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;


    public RoomController(BuildingDao buildingDao, RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao) {
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
    }

    @GetMapping
    public List<RoomDto> findAll() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());  // (6)
    }

    @PostMapping // (8)  créer une room
    public RoomDto create(@RequestBody RoomDto dto) {
        // RoomDto must always contain the room building
        Building building = buildingDao.getById(dto.getBuildingId());
        Room room = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            room = roomDao.save(new Room(dto.getFloor(), dto.getName(), building, dto.getCurrentTemperature(), dto.getTargetTemperature() ));
        } else {
            room = roomDao.getById(dto.getId());  // (9)
        }
        return new RoomDto(room);
    }

    @GetMapping(path = "/{id}")
    public RoomDto findById(@PathVariable Long id) {
        return roomDao.findById(id).map(RoomDto::new).orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        heaterDao.deleteAllHeatersInARoom(id);
        windowDao.deleteAllWindowsInARoom(id);
        roomDao.deleteById(id);
    }

    @GetMapping(path="/{id}/heaters")
    public List<HeaterDto> findAllHeaters(@PathVariable Long id) {
        List<Heater> heaters = roomDao.findRoomHeaters(id);
        return heaters.stream().map(HeaterDto::new).collect(Collectors.toList());
    }

    @GetMapping(path="/{id}/windows")
    public List<WindowDto> findAllWindows(@PathVariable Long id) {
        List<Window> windows = roomDao.findRoomWindows(id);
        return windows.stream().map(WindowDto::new).collect(Collectors.toList());
    }


    @GetMapping(path="/{id}/switchWindows")
    public void switchWindowsStatus(@PathVariable Long id) {
        List<Window> windows = windowDao.findWindowsInARoom(id);
        windows.stream().forEach(window -> window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN));
    }

    @GetMapping(path="/{id}/switchHeaters")
    public void switchHeatersStatus(@PathVariable Long id) {
        List<Heater> heaters = heaterDao.findHeatersInARoom(id);
        heaters.stream().forEach(heater -> heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON));
    }
    
        //Update a room
    @PutMapping(path = "/{id}")
    public RoomDto updateTargetTemperature(@PathVariable Long id, @RequestBody RoomDto room) {
        Room original = roomDao.findById(id).orElseThrow(IllegalArgumentException::new);

        original.setTargetTemperature(room.getTargetTemperature());

        return new RoomDto(original);
    }

}
