package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import com.emse.spring.faircorp.model.Room;
import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// Je définis ici mes queries personnalisées sur le model room

public class RoomDaoCustomImpl implements RoomDaoCustom {

    @PersistenceContext
    private EntityManager em;
    
    // J'affiche ici la room dont l'id a été entré

    public List<Room> findRoom(Long id) {
        String jpql = "select w from Room where id = :id";
        return em.createQuery(jpql, Room.class)
                .setParameter("id", id)
                .getResultList();
    }

    // Cette query liste tous les heaters présents dans la room dont on a rentré l'id
    @Override
    public List<Heater> findRoomHeaters(Long id) {
        String jpql="select h from Heater h where h.room.id=:id";
        return em.createQuery(jpql, Heater.class)
                .setParameter("id", id)
                .getResultList();
    }

    // Cette query liste tous les windows présents dans la room dont on a rentré l'id
    @Override
    public List<Window> findRoomWindows(Long id) {
        String jpql="select w from Window w where w.room.id=:id";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .getResultList();
    }

    // Cette query supprime l'ensemble des rooms présents dans un building dont on a rentré l'id
    @Override
    public void deleteAllRoomsInABuilding(Long id) {
        String jpql = "delete from Room r where r.building.id=:id";
        em.createQuery(jpql)
                .setParameter("id", id)
                .executeUpdate();


    }




}
