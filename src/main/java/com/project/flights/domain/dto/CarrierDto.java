package com.project.flights.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CarrierDto {

    private Long id;
    private String name;
    private List<Long> flightsId;
}
