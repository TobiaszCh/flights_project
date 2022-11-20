package com.project.flights.controller;

import com.google.gson.Gson;
import com.project.flights.domain.Carrier;
import com.project.flights.domain.dto.CarrierDto;
import com.project.flights.mapper.CarrierMapper;
import com.project.flights.service.DbCarrierService;
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
@WebMvcTest(CarrierController.class)
public class CarrierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbCarrierService dbCarrierService;

    @MockBean
    private CarrierMapper carrierMapper;

    @Test
    void checkGetCarrier() throws Exception {
        //Given
        when(carrierMapper.mapToCarrierDtoList(any())).thenReturn(List.of());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/carriers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void checkGetCarrierId() throws Exception {
        //Given
        Carrier carrier = new Carrier(1L, "LOT");
        CarrierDto carrierDto = new CarrierDto(1L, "LOT");
        when(dbCarrierService.getCarrier(1L)).thenReturn(carrier);
        when(carrierMapper.mapToCarrierDto(carrier)).thenReturn(carrierDto);
        ////When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/carriers/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.is("LOT")));

    }

    @Test
    void checkPostCarrierId() throws Exception {
        //Given
        Carrier carrier = new Carrier(1L, "LOT");
        CarrierDto carrierDto = new CarrierDto(1L, "LOT");
        when(dbCarrierService.saveCarrier(carrierMapper.mapToCarrier(carrierDto))).thenReturn(carrier);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(carrierDto);

        ////When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/v1/carriers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void checkDeleteCarrierId() throws Exception {
        //Given
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/carriers/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
