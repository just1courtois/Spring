package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// Je crée mes queries personnalisées ici

public class BuildingDaoCustomImpl implements BuildingDaoCustom{
    @PersistenceContext
    private EntityManager em;

    @Override //Je crée la query qui va me permettre de lister toutes les rooms contenues dans un building
    public List<Room> findBuildingRooms(Long id) {
        String jpql="select r from Room r where r.building.id=:id";
        return em.createQuery(jpql, Room.class)
                .setParameter("id", id)
                .getResultList();
    }


}
