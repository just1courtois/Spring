package com.emse.spring.faircorp.controller;


import com.emse.spring.faircorp.dao.RoomDao;
import com.emse.spring.faircorp.dao.WindowDao;
import com.emse.spring.faircorp.dto.WindowDto;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

// Controller pour gérer les windows

@CrossOrigin
@RestController 
    @RequestMapping("/api/windows")
    @Transactional 
    public class WindowController {

        private final WindowDao windowDao;
        private final RoomDao roomDao;

        public WindowController(WindowDao windowDao, RoomDao roomDao) {
            this.windowDao = windowDao;
            this.roomDao = roomDao;
        }

        @GetMapping // J'obtiens la liste des windows existantes
        public List<WindowDto> findAll() {
            return windowDao.findAll().stream().map(WindowDto::new).collect(Collectors.toList());  
        }

        @GetMapping(path = "/{id}") // J'obtiens l'ensemble des informations concernant la window dont j'ai rentré l'id
        public WindowDto findById(@PathVariable Long id) {
            return windowDao.findById(id).map(WindowDto::new).orElse(null); 
        }

        @PutMapping(path = "/{id}/switch") // Je change le statut de la window dont j'ai rentré l'id
        public WindowDto switchStatus(@PathVariable Long id) {
            Window window = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);
            window.setWindowStatus(window.getWindowStatus() == WindowStatus.OPEN ? WindowStatus.CLOSED: WindowStatus.OPEN);
            return new WindowDto(window);
        }

        @PostMapping // Je crée une nouvelle room si une room avec l'id entré n'existe pas
        public WindowDto create(@RequestBody WindowDto dto) {
            // WindowDto must always contain the window room
            Room room = roomDao.getById(dto.getRoomId());
            Window window = null;
            // On creation id is not defined
            if (dto.getId() == null) {
                window = windowDao.save(new Window(room, dto.getName(), dto.getWindowStatus()));
            }
            else {
                window = windowDao.getById(dto.getId());  // (9)
                window.setWindowStatus(dto.getWindowStatus());
            }
            return new WindowDto(window);
        }

        @DeleteMapping(path = "/{id}") // Je supprime la window dont j'ai rentré l'id
        public void delete(@PathVariable Long id) {
            windowDao.deleteById(id);
        }
    }

