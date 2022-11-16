package com.project.flights.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DatesDto {

    private Long id;
    private LocalDateTime departure;
    private LocalDateTime arrival;
}
