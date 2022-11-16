package com.project.flights.service;

import com.project.flights.domain.Ticket;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbTicketService {

    private final TicketRepository ticketRepository;

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicket(Long ticketId) throws AllNotFoundException {
        return ticketRepository.findById(ticketId).orElseThrow(AllNotFoundException::new);
    }

    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public void deleteCarrier(Long ticketId) {
        ticketRepository.deleteById(ticketId);
    }
}
