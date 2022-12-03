package com.project.flights.domain;

import com.project.flights.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
}
