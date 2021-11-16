package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

// Dao pour le model heater

public interface HeaterDao extends JpaRepository<Heater,Long> , HeaterDaoCustom {

    @Modifying
    @Query
            ("delete from Heater h where h.room.id = (select r.id from h.room r where r.building.id = :id)")
    void deleteAllHeatersInABuilding(Long id);
}


