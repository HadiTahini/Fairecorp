package com.example.faircorp.ControllersTest;

import com.example.faircorp.Dao.HeaterDao;
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
public class HeaterControllerTest {
    @Autowired
    MockMvc mockMvc;
    HeaterDao heaterDao;

    @Test
    void shouldLoadHeater() throws Exception{
        mockMvc.perform(get("/api/heaters/-10").accept(APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    void shouldLoadHeaters() throws Exception {
        mockMvc.perform(get("/api/heaters").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON));
    }
    @Test
    void shouldLoadAHeaterAndReturnNullIfNotFound() throws Exception {
        given(heaterDao.findById(999L)).willReturn(Optional.empty());
        mockMvc.perform(get("/api/heater/999").accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }
    @Test
    void shouldCreateRoom() throws Exception {
        mockMvc.perform(post("/api/heaters").contentType(APPLICATION_JSON_VALUE)
                        .content("name:"+"myHeater"+"\n"+"power:"+"100"+"\n"+"status"+"ON"+"\n"+
                                "roomId:"+"-10"))
                // check the HTTP response
                .andExpect(status().isOk());

    }
    @Test
    void shouldDeleteHeater() throws Exception {
        mockMvc.perform(delete("/api/heater/-10"))
                .andExpect(status().isOk());
    }
}
