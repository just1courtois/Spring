package com.emse.spring.faircorp.dao;

import com.emse.spring.faircorp.model.Heater;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

// Je définis ici mes queries personnalisées pour le model heater

public class HeaterDaoCustomImpl implements HeaterDaoCustom {

    @PersistenceContext
    private EntityManager em;


    // Cette query permet de supprimer un heater selon l'id rentré
    @Override
    public void deleteByHeater(Long id) {
        String jpql = "delete from Heater h where heater_id = :heater_id";
        em.createQuery(jpql)
                .setParameter("heater_id", id)
                .executeUpdate();
    }

    // Cette query permet de lister tous les heaters présents dans une room dont on a rentré l'id
    @Override
    public List<Heater> findHeatersInARoom(Long id) {
        String jpql = "select h from Heater h where h.room.id=:id";
        return em.createQuery(jpql,Heater.class)
                .setParameter("id",id)
                .getResultList();
    }

     // Cette query permet de supprimer tous les heaters présents dans une room dont on a rentré l'id
    @Override
    public void deleteAllHeatersInARoom(Long id) {
        String jpql = "delete from Heater h where h.room.id=:id";
        em.createQuery(jpql)
                .setParameter("id", id)
                .executeUpdate();
    }


}
