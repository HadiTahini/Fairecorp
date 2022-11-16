package com.example.faircorp.ControllersTest;


import com.example.faircorp.Dao.WindowDao;
import com.example.faircorp.Enums.WindowStatus;
import com.example.faircorp.Pattern.Room;
import com.example.faircorp.Pattern.Window;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc()
class WindowControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    WindowDao windowDao;

    @Test
    void shouldLoadWindow() throws Exception{
        mockMvc.perform(get("/api/windows/-10").accept(APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void shouldLoadWindows() throws Exception {
        mockMvc.perform(get("/api/windows").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON));
    }

    @Test
    void shouldLoadAWindowAndReturnNullIfNotFound() throws Exception {
        given(windowDao.findById(999L)).willReturn(Optional.empty());
        mockMvc.perform(get("/api/windows/999").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    void shouldSwitchWindow() throws Exception {
        Window expectedWindow = createWindow("window 1");
        given(windowDao.findById(-10L)).willReturn(Optional.of(expectedWindow));
        mockMvc.perform(put("/api/windows/-10/switch").accept(APPLICATION_JSON))
                // check the HTTP response
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("window 1"))
                .andExpect(jsonPath("$.windowStatus").value("CLOSED"));
    }

    @Test
    void shouldUpdateWindow() throws Exception {
        mockMvc.perform(post("/api/windows").contentType(APPLICATION_JSON_VALUE))
                // check the HTTP response
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("window 1"))
                .andExpect(jsonPath("$.id").value("1"));
    }

    @Test
    void shouldCreateWindow() throws Exception {
        mockMvc.perform(post("/api/windows").contentType(APPLICATION_JSON_VALUE)
                        .content("name:" + "myWindow" + "\n" + "status" + "ON" + "\n" +
                                "roomId:" + "-10"))
                // check the HTTP response
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteWindow() throws Exception {
        mockMvc.perform(delete("/api/windows/-10"))
                .andExpect(status().isOk());
    }

    private Window createWindow(String name) {
        Room room = new Room("S1", 1);
        return new Window(name, WindowStatus.OPEN, room);
    }

}