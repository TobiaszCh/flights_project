package com.project.flights.mapper;

import com.project.flights.domain.Dates;
import com.project.flights.domain.dto.DatesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DatesMapper {

    public Dates mapToDates(final DatesDto datesDto) {
        return new Dates(
                datesDto.getId(),
                datesDto.getDeparture(),
                datesDto.getArrival());
    }

    public DatesDto mapToDatesDto(final Dates dates) {
        return new DatesDto(
                dates.getId(),
                dates.getDeparture(),
                dates.getArrival());
    }

    public List<DatesDto> mapToDatesDtoList(List<Dates> datesList) {
        return datesList.stream()
                .map(this::mapToDatesDto)
                .collect(Collectors.toList());
    }
}
