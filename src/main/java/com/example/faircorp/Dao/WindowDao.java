package com.example.faircorp.Dao;

import com.example.faircorp.Pattern.Window;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WindowDao extends JpaRepository<Window,Long>, WindowDaoCustom {
    void deleteById(Long id);
    Window getReferenceById(Long id);
}
