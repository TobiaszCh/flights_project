package com.project.flights.mapper;

import com.project.flights.domain.Flight;
import com.project.flights.domain.Place;
import com.project.flights.domain.dto.FlightDto;
import com.project.flights.domain.dto.PlaceDto;
import com.project.flights.repository.CarrierRepository;
import com.project.flights.repository.DatesRepository;
import com.project.flights.repository.PlaceRepository;
import com.project.flights.repository.TicketRepository;
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
                flightDto.getId(),
                ticketRepository.findById(flightDto.getTicketId()).orElseThrow(() -> new RuntimeException("Ticket does not exist!")),
                placeRepository.findById(flightDto.getPlaceId()).orElseThrow(() -> new RuntimeException("Place does not exist!")),
                datesRepository.findById(flightDto.getDatesId()).orElseThrow(() -> new RuntimeException("Dates does not exist!")),
                carrierRepository.findById(flightDto.getCarrierId()).orElseThrow(() -> new RuntimeException("Carrier does not exist!")));

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


