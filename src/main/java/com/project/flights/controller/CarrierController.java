package com.project.flights.controller;

import com.project.flights.domain.Carrier;
import com.project.flights.domain.dto.CarrierDto;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.mapper.CarrierMapper;
import com.project.flights.service.DbCarrierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/carriers")
public class CarrierController {

    private final DbCarrierService dbCarrierService;
    private final CarrierMapper carrierMapper;

    @GetMapping
    public ResponseEntity<List<CarrierDto>> getCarriers() {
        List<Carrier> carriers = dbCarrierService.getAllCarriers();
        return ResponseEntity.ok(carrierMapper.mapToCarrierDtoList(carriers));
    }

    @GetMapping(value = "{carrierId}")
    public ResponseEntity<CarrierDto> getCarrier(@PathVariable Long carrierId) throws AllNotFoundException {
        return ResponseEntity.ok(carrierMapper.mapToCarrierDto(dbCarrierService.getCarrier(carrierId)));
    }

    @PostMapping
    public ResponseEntity<Void> createCarrier(@RequestBody CarrierDto carrierDto) {
        Carrier carrier = carrierMapper.mapToCarrier(carrierDto);
        dbCarrierService.saveCarrier(carrier);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{carrierId}")
    public ResponseEntity<Void> deleteCarrier(@PathVariable Long carrierId) {
        dbCarrierService.deleteCarrier(carrierId);
        return ResponseEntity.ok().build();
    }

}
