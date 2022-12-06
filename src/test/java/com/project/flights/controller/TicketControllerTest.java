package com.project.flights.controller;

import com.google.gson.Gson;
import com.project.flights.domain.Ticket;
import com.project.flights.domain.dto.TicketDto;
import com.project.flights.mapper.TicketMapper;
import com.project.flights.service.DbTicketService;
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
@WebMvcTest(TicketController.class)
public class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbTicketService dbTicketService;

    @MockBean
    private TicketMapper ticketMapper;

    @Test
    void checkGetTicket() throws Exception {
        //Given
        when(ticketMapper.mapToTicketDtoList(any())).thenReturn(List.of());

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/tickets")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(0)));
    }

    @Test
    void checkGetTicketId() throws Exception {
        //Given
        Ticket ticket = new Ticket("LOW", 100);
        TicketDto ticketDto = new TicketDto(1L, "LOW", 100);
        when(dbTicketService.getTicket(1L)).thenReturn(ticket);
        when(ticketMapper.mapToTicketDto(ticket)).thenReturn(ticketDto);
        ////When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/v1/tickets/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.kindOfPrice", Matchers.is("LOW")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price", Matchers.is(100.0)));
    }

    @Test
    void checkPostTicketId() throws Exception {
        //Given
        TicketDto ticketDto = new TicketDto(1L, "LOW", 100);
        Gson gson = new Gson();
        String jsonContent = gson.toJson(ticketDto);

        ////When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/v1/tickets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void checkDeleteTicketId() throws Exception {
        //Given
        //When & Then
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("/v1/tickets/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}