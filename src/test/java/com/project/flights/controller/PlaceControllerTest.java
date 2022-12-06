package com.project.flights.controller;

import com.google.gson.Gson;
import com.project.flights.domain.Place;
import com.project.flights.domain.dto.PlaceDto;
import com.project.flights.mapper.PlaceMapper;
import com.project.flights.service.DbPlaceService;
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
@WebMvcTest(PlaceController.class)
public class PlaceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbPlaceService dbPlaceService;

    @MockBean
    private PlaceMapper placeMapper;

    @Test
    void checkGetPlace() throws Exception {
        //Given
        when(placeMapper.mapToPlaceDtoList(any())).thenReturn(List.of());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/places")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void checkGetPlaceId() throws Exception {
        //Given
        Place place = new Place("Europa", "Wlochy", "Mediolan");
        PlaceDto placeDto = new PlaceDto(1L, "Europa", "Wlochy", "Mediolan");
        when(dbPlaceService.getPlace(1L)).thenReturn(place);
        when(placeMapper.mapToPlaceDto(place)).thenReturn(placeDto);
        ////When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/places/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.continent", Matchers.is("Europa")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.country", Matchers.is("Wlochy")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.city", Matchers.is("Mediolan")));
    }

    @Test
    void checkPostPlaceId() throws Exception {
        //Given
        PlaceDto placeDto = new PlaceDto(1L, "Europa", "Wlochy", "Mediolan");
        Gson gson = new Gson();
        String jsonContent = gson.toJson(placeDto);
        ////When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/v1/places")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void checkDeletePlaceId() throws Exception {
        //Given
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/places/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}