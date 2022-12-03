package com.project.flights.mapper;

import com.project.flights.domain.Place;
import com.project.flights.domain.dto.PlaceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceMapper {

    public Place mapToPlace(final PlaceDto placeDto) {
        return new Place(
                placeDto.getContinent(),
                placeDto.getCountry(),
                placeDto.getCity());
    }

    public PlaceDto mapToPlaceDto(final Place place) {
        return new PlaceDto(
                place.getId(),
                place.getContinent(),
                place.getCountry(),
                place.getCity());
    }

    public List<PlaceDto> mapToPlaceDtoList(List<Place> placeList) {
        return placeList.stream()
                .map(this::mapToPlaceDto)
                .collect(Collectors.toList());
    }
}
