package com.project.flights.mapper;

import com.project.flights.domain.Carrier;
import com.project.flights.domain.Flight;
import com.project.flights.domain.dto.CarrierDto;
import com.project.flights.repository.FlightRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarrierMapper {

    private FlightRepository flightRepository;

    public Carrier mapToCarrier(final CarrierDto carrierDto) {
        return new Carrier(
                carrierDto.getId(),
                carrierDto.getName(),
                Optional.ofNullable(flightRepository.findAllById(carrierDto.getFlightsId()))
                        .orElse(Collections.emptyList()));

    }

    public CarrierDto mapToCarrierDto(final Carrier carrier) {
        return new CarrierDto(
                carrier.getId(),
                carrier.getName(),
                Optional.of(carrier.getFlights().stream().map(Flight::getId).collect(Collectors.toList())).orElse(Collections.emptyList())
        );
    }

    public List<CarrierDto> mapToCarrierDtoList(List<Carrier> carrierList) {
        return carrierList.stream()
                .map(this::mapToCarrierDto)
                .collect(Collectors.toList());
    }


}
