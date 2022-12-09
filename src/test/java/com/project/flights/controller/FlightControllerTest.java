package com.project.flights.controller;

import com.google.gson.Gson;
import com.project.flights.domain.dto.FlightDto;
import com.project.flights.mapper.FlightMapper;
import com.project.flights.service.DbFlightService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(FlightController.class)
public class FlightControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbFlightService flightService;

    @MockBean
    private FlightMapper flightMapper;

    @Test
    void checkGetFlight() throws Exception {
        //Given
        when(flightMapper.mapToFlightDtoList(any())).thenReturn(List.of());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/flights")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void checkGetFlightId() throws Exception {
        //Given
        ////When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/places/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


    @Test
    void checkPostFlightId() throws Exception {
        //Given
        FlightDto flightDto = new FlightDto(1L,2L,3L, 4L, 5L);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(flightDto);
        ////When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/v1/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void checkDeleteFlightId() throws Exception {
        //Given
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/flights/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
