package com.project.flights.controller;

import com.project.flights.domain.Flight;
import com.project.flights.domain.dto.FlightDto;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.mapper.FlightMapper;
import com.project.flights.service.DbFlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/flights")
public class FlightController {

    private final DbFlightService dbFlightService;
    private final FlightMapper flightMapper;

    @GetMapping
    public ResponseEntity<List<FlightDto>> getFlights() {
        List<Flight> flights = dbFlightService.getAllFlight();
        return ResponseEntity.ok(flightMapper.mapToFlightDtoList(flights));
    }

    @GetMapping(value = "{flightId}")
    public ResponseEntity<FlightDto> getFlight(@PathVariable Long flightId) throws AllNotFoundException {
        return ResponseEntity.ok(flightMapper.mapToFlightDto(dbFlightService.getFlight(flightId)));
    }

    @PostMapping
    public ResponseEntity<Void> createFlight(@RequestBody FlightDto flightDto) {
        Flight flight = flightMapper.mapToFlight(flightDto);
        dbFlightService.saveFlight(flight);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long flightId) {
        dbFlightService.deleteFlight(flightId);
        return ResponseEntity.ok().build();
    }
}
