package com.project.flights.controller;

import com.project.flights.domain.dto.CarrierDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/flights")
public class CarrierController {

    @GetMapping
    public List<CarrierDto> getFlights() {
        return new ArrayList<>();
    }

    @GetMapping(value = "{flightId}")
    public CarrierDto getFlight(@PathVariable Long flightId) {
        return new CarrierDto(1L, "Lot");
    }

    @DeleteMapping(value = "{flightId}")
    public void deleteFlight(@PathVariable Long flightId) {
        System.out.println("Delete");
    }

    @PutMapping
    public CarrierDto updateFlight(CarrierDto carrierDto) {
        return new CarrierDto(1L, "Lot1");
    }

    @PostMapping
    public void createCarrier(CarrierDto carrierDto) {

    }
}
