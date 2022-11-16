package com.example.faircorp.ControllersTest;

import com.example.faircorp.Dao.RoomDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class RoomControllerTest {
    @Autowired
    MockMvc mockMvc;
    RoomDao roomDao;

    @Test
    @WithMockUser(username = "user",roles = "USER")
    void shouldLoadRoom() throws Exception{
        mockMvc.perform(get("/api/rooms/-10").accept(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldLoadRooms() throws Exception {
        mockMvc.perform(get("/api/rooms").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON));
    }
    @Test
    void shouldLoadARoomAndReturnNullIfNotFound() throws Exception {
        given(roomDao.findById(999L)).willReturn(Optional.empty());
        mockMvc.perform(get("/api/room/999").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    void shouldCreateRoom() throws Exception {
        mockMvc.perform(post("/api/rooms").contentType(APPLICATION_JSON_VALUE)
                        .content("name:"+"myRoom"+"\n"+"floor:"+"5"+"\n"+"currentTemperature"+"11"+"\n"+
                                "targetTemperature:"+"18"))
                // check the HTTP response
                .andExpect(status().isOk());

    }
    @Test
    void shouldDeleteRoom() throws Exception {
        mockMvc.perform(delete("/api/Room/-10"))
                .andExpect(status().isOk());
    }
}
