package com.project.flights.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FlightDto {

    private Long Id;
    private Long ticketId;
    private Long placeId;
    private Long datesId;
    private Long carrierId;
}
