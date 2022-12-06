package com.project.flights.domain;

import com.project.flights.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TicketRepositoryTestSuite {

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    public void testFindAllTicket() {
        //Given
        Ticket ticket = new Ticket();
        Ticket ticket1 = new Ticket();
        //When
        ticketRepository.save(ticket);
        ticketRepository.save(ticket1);
        //Then
        assertEquals(2, ticketRepository.findAll().size());
        //Clean
        ticketRepository.deleteAll();
    }

    @Test
    public void testFindTicketById() {
        //Given
        Ticket ticket = new Ticket();
        //When
        ticketRepository.save(ticket);
        Long id = ticket.getId();
        Optional<Ticket> foundCart = ticketRepository.findById(id);
        //Then
        assertEquals(foundCart.get().getId(), id);
        //Clean
        ticketRepository.deleteAll();
    }

    @Test
    public void testSaveTicketById() {
        //Given
        Ticket ticket = new Ticket();
        //When
        ticketRepository.save(ticket);
        Long id = ticket.getId();
        Optional<Ticket> foundCart = ticketRepository.findById(id);
        //Then
        assertTrue(foundCart.isPresent());
        //Clean
        ticketRepository.deleteAll();
    }

    @Test
    public void testDeleteTicketById() {
        //Given
        Ticket ticket = new Ticket();
        //When
        ticketRepository.save(ticket);
        ticketRepository.delete(ticket);
        Long id = ticket.getId();
        Optional<Ticket> foundCart = ticketRepository.findById(id);
        //Then
        assertFalse(foundCart.isPresent());
    }

    @Test
    public void testRelationWithFlight() {
        //Given
        Ticket ticket = new Ticket();
        Flight flight = new Flight();
        //When
        ticket.getFlights().add(flight);
        long size = ticket.getFlights().size();
        //Then
        assertEquals(1, size);
        //Clean
        ticketRepository.deleteAll();
    }
}
