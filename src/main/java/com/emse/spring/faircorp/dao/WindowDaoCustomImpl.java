package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Window;
import com.emse.spring.faircorp.model.WindowStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// Je crée ici mes queries personnalisées pour le model window

public class WindowDaoCustomImpl implements WindowDaoCustom {

    @PersistenceContext
    private EntityManager em;


 
    @Override
    public void deleteByRoom(Long id) {
        String jpql = "delete from Window w where room_id = :room_id";
        em.createQuery(jpql)
                .setParameter("room_id", id)
                .executeUpdate();
    }
    
    // J'affiche ici tous les windows avec le statut OPEN qui sont dans la room dont on a rentré l'id
    @Override
    public List<Window> findRoomOpenWindows(Long id) {
        String jpql = "select w from Window w where w.room.id = :id and w.windowStatus= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }

    // Cette query supprime les windows présents dans la room dont on a rentré l'id
    @Override
    public void deleteAllWindowsInARoom(Long id) {
        String jpql = "delete from Window w where w.room.id=:id";
        em.createQuery(jpql)
                .setParameter("id", id)
                .executeUpdate();
    }

    // Cette query liste tous les windows présents dans la room dont on a rentré l'id
    @Override
    public List<Window> findWindowsInARoom(Long id) {
        String jpql = "select w from Window w where w.room.id=:id";
        return em.createQuery(jpql,Window.class)
                .setParameter("id",id)
                .getResultList();
    }



}
