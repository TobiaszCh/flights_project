package com.project.flights.service;

import com.project.flights.domain.Flight;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbFlightService {

    private final FlightRepository flightRepository;

    public List<Flight> getAllFlight() {
        return flightRepository.findAll();
    }

    public Flight getFlight(Long flightId) throws AllNotFoundException {
        return flightRepository.findById(flightId).orElseThrow(AllNotFoundException::new);
    }

    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }
}
