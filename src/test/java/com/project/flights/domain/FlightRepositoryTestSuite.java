package com.project.flights.domain;

import com.project.flights.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FlightRepositoryTestSuite {

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testFindAllFlight() {
        //Given
        Flight flight = new Flight();
        Flight flight1 = new Flight();
        //When
        flightRepository.save(flight);
        flightRepository.save(flight1);
        //Then
        assertEquals(2, flightRepository.findAll().size());
        //Clean
        flightRepository.deleteAll();
    }

    @Test
    public void testFindFlightById() {
        //Given
        Flight flight = new Flight();
        //When
        flightRepository.save(flight);
        Long id = flight.getId();
        Optional<Flight> foundCart = flightRepository.findById(id);
        //Then
        assertEquals(foundCart.get().getId(), id);
        //Clean
        flightRepository.deleteAll();
    }

    @Test
    public void testSaveFlightById() {
        //Given
        Flight flight = new Flight();
        //When
        flightRepository.save(flight);
        Long id = flight.getId();
        Optional<Flight> foundCart = flightRepository.findById(id);
        //Then
        assertTrue(foundCart.isPresent());
        //Clean
        flightRepository.deleteAll();
    }

    @Test
    public void testDeleteFlightById() {
        //Given
        Flight flight = new Flight();
        //When
        flightRepository.save(flight);
        flightRepository.delete(flight);
        Long id = flight.getId();
        Optional<Flight> foundCart = flightRepository.findById(id);
        //Then
        assertFalse(foundCart.isPresent());
    }

    @Test
    public void testRelationWithAll() {
        //Given
        Place place = new Place("Europa", "Polska","Warszawa");
        Carrier carrier = new Carrier("Lot");
        Dates dates = new Dates(LocalDateTime.of(2022, 10, 1, 10,16),
                LocalDateTime.of(2022, 10, 1, 16,18));
        Ticket ticket = new Ticket("small", 300.0);
        Flight flight = new Flight(ticket, place, dates, carrier);
        //When
        String test1 = flight.getCarrier().getName();
        String test2 = flight.getPlace().getCity();
        int test4 = flight.getDate().getArrival().getMonthValue();
        int test5 = flight.getDate().getDeparture().getMinute();
        double test6 = flight.getTicket().getPrice();

        //Then
        assertEquals("Lot", test1);
        assertEquals("Warszawa", test2);
        assertEquals(10, test4);
        assertEquals(16, test5);
        assertEquals(300.0, test6);
        //Clean
        flightRepository.deleteAll();
    }
}
