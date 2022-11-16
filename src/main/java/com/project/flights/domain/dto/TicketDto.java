package com.project.flights.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TicketDto {

    private Long id;
    private String kindOfPrice;
    private double price;
}
