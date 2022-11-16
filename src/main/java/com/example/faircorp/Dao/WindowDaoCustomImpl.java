package com.example.faircorp.Dao;

import com.example.faircorp.Enums.WindowStatus;
import com.example.faircorp.Pattern.Window;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class WindowDaoCustomImpl implements WindowDaoCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Window> findRoomOpenWindows(Long id) {
        String jpql = "select w from Window w where w.room.id = :id and w.windowStatus= :status";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .setParameter("status", WindowStatus.OPEN)
                .getResultList();
    }

    @Override
    public List<Window> findRWindowByRoomName(String name) {
        String jpql = "select w from Window w where w.room.name = :name";
        return em.createQuery(jpql, Window.class)
                .setParameter("name", name)
                .getResultList();
    }


    @Override
    public List<Window> deleteAllWindowInRoom(Long id) {
        String jpql = "delete from Window w where w.room.id = :id";
        return em.createQuery(jpql, Window.class)
                .setParameter("id", id)
                .getResultList();
    }


}

