package com.emse.spring.faircorp.controller;


import com.emse.spring.faircorp.dao.HeaterDao;
import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.HeaterDto;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.*;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController 
@RequestMapping("/api/heaters") 
@Transactional 
public class HeaterController {

    private final HeaterDao heaterDao;
    private final RoomDao roomDao;

    public HeaterController(HeaterDao heaterDao, RoomDao roomDao) { // (4)
        this.heaterDao = heaterDao;
        this.roomDao = roomDao;
    }

    @GetMapping // Je demande la liste des heaters existants
    public List<HeaterDto> findAll() {
        return heaterDao.findAll().stream().map(HeaterDto::new).collect(Collectors.toList());  // (6)
    }

    @GetMapping(path = "/{id}") // J'obtiens l'ensemble des informations sur le heater dont j'ai rentré l'id
    public HeaterDto findById(@PathVariable Long id) {
        return heaterDao.findById(id).map(HeaterDto::new).orElse(null); // (7)
    }

    @PutMapping(path = "/{id}/switch") // Je modifie le statut de l'heater dont j'ai rentré l'id
    public HeaterDto switchStatus(@PathVariable Long id) {
        Heater heater = heaterDao.findById(id).orElseThrow(IllegalArgumentException::new);
        heater.setHeaterStatus(heater.getHeaterStatus() == HeaterStatus.ON ? HeaterStatus.OFF: HeaterStatus.ON);
        return new HeaterDto(heater);
    }

    @PostMapping // Je crée un nouveau heater s'il l'id que j'ai entré n'existe pas
    public HeaterDto create(@RequestBody HeaterDto dto) {
        // HeaterDto must always contain the heater room
        Room room = roomDao.getById(dto.getRoomId());
        Heater heater = null;
        // On creation id is not defined
        if (dto.getId() == null) {
           heater = heaterDao.save(new Heater(dto.getName(), room, dto.getHeaterStatus(),dto.getPower()));
        }
        else {
            heater = heaterDao.getById(dto.getId());  // (9)
            heater.setHeaterStatus(dto.getHeaterStatus());
            heater.setPower(dto.getPower());
        }
        return new HeaterDto(heater);
    }

    @DeleteMapping(path = "/{id}") // Je supprime le heater dont j'ai rentré l'id
    public void delete(@PathVariable Long id) {
        heaterDao.deleteById(id);
    }
}
