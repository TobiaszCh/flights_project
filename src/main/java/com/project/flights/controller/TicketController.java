package com.project.flights.controller;

import com.project.flights.domain.Ticket;
import com.project.flights.domain.dto.TicketDto;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.mapper.TicketMapper;
import com.project.flights.service.DbTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/tickets")
public class TicketController {

    private final DbTicketService dbTicketService;
    private final TicketMapper ticketMapper;

    @GetMapping
    public ResponseEntity<List<TicketDto>> getTickets() {
        List<Ticket> tickets = dbTicketService.getAllTickets();
        return ResponseEntity.ok(ticketMapper.mapToTicketDtoList(tickets));
    }

    @GetMapping(value = "{ticketId}")
    public ResponseEntity<TicketDto> getTicket(@PathVariable Long ticketId) throws AllNotFoundException {
        return ResponseEntity.ok(ticketMapper.mapToTicketDto(dbTicketService.getTicket(ticketId)));
    }

    @PostMapping
    public ResponseEntity<Void> createCarrier(@RequestBody TicketDto ticketDto) {
        Ticket ticket = ticketMapper.mapToTicket(ticketDto);
        dbTicketService.saveTicket(ticket);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{ticketId}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long ticketId) {
        dbTicketService.deleteCarrier(ticketId);
        return ResponseEntity.ok().build();
    }
}
