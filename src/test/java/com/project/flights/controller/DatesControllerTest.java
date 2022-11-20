package com.project.flights.controller;

import com.project.flights.mapper.DatesMapper;
import com.project.flights.service.DbDatesService;
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
@WebMvcTest(DatesController.class)
public class DatesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbDatesService dbDatesService;

    @MockBean
    private DatesMapper datesMapper;

    @Test
    void checkGetDates() throws Exception {
        //Given
        when(datesMapper.mapToDatesDtoList(any())).thenReturn(List.of());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/dates")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

/*    @Test
    void checkGetCarrierId() throws Exception {
        //Given
        ////When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/dates/1/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }*/

/*    @Test
    void checkPostCarrierId() throws Exception {
        //Given
        DatesDto datesDto = new DatesDto(1L, LocalDateTime.of(2022, 10, 12,10,10), LocalDateTime.of(2022, 10, 12,10,10).plusHours(6));

        Gson gson = new Gson();
        String jsonContent = gson.toJson(datesDto);

        ////When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/v1/dates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }*/

    @Test
    void checkDeleteDatesId() throws Exception {
        //Given
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/dates/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
