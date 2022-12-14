package com.project.flights.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlaceDto {

    private Long id;
    private String continent;
    private String country;
    private String city;
}
