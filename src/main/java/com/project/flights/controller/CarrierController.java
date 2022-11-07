package com.project.flights.controller;

import com.project.flights.domain.Carrier;
import com.project.flights.domain.dto.CarrierDto;
import com.project.flights.mapper.CarrierMapper;
import com.project.flights.service.DbCarrierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/carriers")
public class CarrierController {

    private final DbCarrierService dbCarrierService;
    private final CarrierMapper carrierMapper;

    @GetMapping
    public List<CarrierDto> getFlights() {
        List<Carrier> carriers = dbCarrierService.getAllTasks();
        return carrierMapper.mapToCarrierDtoList(carriers);
    }

/*    @GetMapping(value = "{carriersId}")
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


    @PostMapping
    public void createCarrier(CarrierDto carrierDto) {

    }*/

}
