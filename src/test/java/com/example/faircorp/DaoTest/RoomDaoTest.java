package com.example.faircorp.DaoTest;

import com.example.faircorp.Dao.RoomDao;
import com.example.faircorp.Enums.WindowStatus;
import com.example.faircorp.Pattern.Room;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RoomDaoTest {
    @Autowired
    private RoomDao roomDao;

    @Test
    public void ShouldFindARoomByItsName(){
        List<Room> result = roomDao.findRoomByName("Room1");
        Assertions.assertThat(result).hasSize(10);
    }

    @Test
    public void shouldFindARoom() {
        List<Room> result = roomDao.findRoomsWithOpenWindow("OPEN");
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("id", "windowStatus")
                .containsExactly(Tuple.tuple(-10L, WindowStatus.OPEN));
    }
}
