package com.emse.spring.faircorp.controller;

import com.emse.spring.faircorp.dao.BuildingDao;
import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.BuildingDto;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.dto.RoomDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.*;
import org.hibernate.bytecode.internal.javassist.BulkAccessor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

// Controller pour la gestion des building

@CrossOrigin
@RestController 
@RequestMapping("/api/buildings") 
@Transactional 


public class BuildingController {

    private final RoomDao roomDao;
    private final BuildingDao buildingDao;
    private final WindowDao windowDao;
    private final HeaterDao heaterDao;


    public BuildingController(BuildingDao buildingDao, RoomDao roomDao, WindowDao windowDao, HeaterDao heaterDao) {
        this.buildingDao = buildingDao;
        this.roomDao = roomDao;
        this.windowDao = windowDao;
        this.heaterDao = heaterDao;
    }

    @GetMapping //je demande à l'api de me lister l'ensemble des buildings existants
    public List<BuildingDto> findAll() {
        return buildingDao.findAll().stream().map(BuildingDto::new).collect(Collectors.toList());  // (6)
    }

    @PostMapping // Je créee un nouveau building s'il l'id entré n'existe pas
    public BuildingDto create(@RequestBody BuildingDto dto) {
        Building building = null;
        // On creation id is not defined
        if (dto.getId() == null) {
            building = buildingDao.save(new Building( dto.getName()));
        } else {
            building = buildingDao.getById(dto.getId());  // (9)
        }
        return new BuildingDto(building);
    }

    @GetMapping(path = "/{id}") // j'obtiens l'ensemble des informations concernant un building en rentrant son id
    public BuildingDto findById(@PathVariable Long id) {
        return buildingDao.findById(id).map(BuildingDto::new).orElse(null);
    }

    @DeleteMapping(path = "/{id}") // Je supprime le building dont j'ai entré l'id ainsi que tous les rooms, windows et heaters liés à celui ci
    public void delete(@PathVariable Long id) {
        windowDao.deleteAllWindowsInABuilding(id);
        heaterDao.deleteAllHeatersInABuilding(id);
        roomDao.deleteAllRoomsInABuilding(id);
        buildingDao.deleteById(id);


    }

    @GetMapping(path="/{id}/rooms") // Je liste toute les rooms que contient le building dont j'ai rentre l'id
    public List<RoomDto> findAllRooms(@PathVariable Long id) {
        List<Room> rooms= buildingDao.findBuildingRooms(id);
        return rooms.stream().map(RoomDto::new).collect(Collectors.toList());
    }





}
