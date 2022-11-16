package com.example.faircorp.Dao;

import com.example.faircorp.Enums.HeaterStatus;
import com.example.faircorp.Pattern.Heater;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HeaterDaoCustomImpl implements HeaterDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Heater> findRoomWithOnHeater(Long id) {
        String jpql = "select w from Heater w where w.room.id = :id and w.heaterStatus= :status";
        return em.createQuery(jpql, Heater.class)
                .setParameter("id", id)
                .setParameter("status", HeaterStatus.ON)
                .getResultList();
    }
}
