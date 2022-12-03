package com.project.flights.mapper;

import com.project.flights.domain.*;
import com.project.flights.domain.dto.FlightDto;
import com.project.flights.domain.dto.PlaceDto;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.repository.CarrierRepository;
import com.project.flights.repository.DatesRepository;
import com.project.flights.repository.PlaceRepository;
import com.project.flights.repository.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightMapper {

    private final TicketRepository ticketRepository;
    private final PlaceRepository placeRepository;
    private final DatesRepository datesRepository;
    private final CarrierRepository carrierRepository;


    public Flight mapToFlight(final FlightDto flightDto) {
        return new Flight(
                ticketRepository.findById(flightDto.getTicketId())
                        .orElseThrow(AllNotFoundException::new),
                placeRepository.findById(flightDto.getPlaceId())
                        .orElseThrow(AllNotFoundException::new),
                datesRepository.findById(flightDto.getDatesId())
                        .orElseThrow(AllNotFoundException::new),
                carrierRepository.findById(flightDto.getCarrierId())
                        .orElseThrow(AllNotFoundException::new));
    }

    public FlightDto mapToFlightDto(final Flight flight) {
        return new FlightDto(
                flight.getId(),
                flight.getTicket().getId(),
                flight.getPlace().getId(),
                flight.getDate().getId(),
                flight.getCarrier().getId());
    }

    public List<FlightDto> mapToFlightDtoList(List<Flight> flightList) {
        return flightList.stream()
                .map(this::mapToFlightDto)
                .collect(Collectors.toList());
    }
}


