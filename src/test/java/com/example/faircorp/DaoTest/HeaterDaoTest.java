package com.example.faircorp.DaoTest;

import com.example.faircorp.Dao.HeaterDao;
import com.example.faircorp.Enums.HeaterStatus;
import com.example.faircorp.Pattern.Heater;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class HeaterDaoTest {
    @Autowired
    private HeaterDao heaterDao;

    @Test
    public void shouldFindAWindow() {
        Heater heater = heaterDao.getReferenceById(-10L);
        Assertions.assertThat(heater.getName()).isEqualTo("Heater1");
        Assertions.assertThat(heater.getHeaterStatus()).isEqualTo(HeaterStatus.ON);
    }

    @Test
    public void shouldFindRoomOpenWindows() {
        List<Heater> result = heaterDao.findRoomWithOnHeater(-10L);
        Assertions.assertThat(result)
                .hasSize(2)
                .extracting("id", "heaterStatus");
    }
}

