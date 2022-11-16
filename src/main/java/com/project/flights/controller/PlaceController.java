package com.project.flights.controller;

import com.project.flights.domain.Place;
import com.project.flights.domain.dto.PlaceDto;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.mapper.PlaceMapper;
import com.project.flights.service.DbPlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/places")
public class PlaceController {

    private final DbPlaceService dbPlaceService;
    private final PlaceMapper placeMapper;

    @GetMapping
    public ResponseEntity<List<PlaceDto>> getPlaces() {
        List<Place> places = dbPlaceService.getAllPlaces();
        return ResponseEntity.ok(placeMapper.mapToPlaceDtoList(places));
    }

    @GetMapping(value = "{placeId}")
    public ResponseEntity<PlaceDto> getPlace(@PathVariable Long placeId) throws AllNotFoundException {
        return ResponseEntity.ok(placeMapper.mapToPlaceDto(dbPlaceService.getPlace(placeId)));
    }

    @PostMapping
    public ResponseEntity<Void> createPlace(@RequestBody PlaceDto placeDto) {
        Place place = placeMapper.mapToPlace(placeDto);
        dbPlaceService.savePlace(place);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "{placeId}")
    public ResponseEntity<Void> deletePlace(@PathVariable Long placeId) {
        dbPlaceService.deletePlace(placeId);
        return ResponseEntity.ok().build();
    }
}
