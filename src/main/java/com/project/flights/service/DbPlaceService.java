package com.project.flights.service;

import com.project.flights.domain.Carrier;
import com.project.flights.domain.Place;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbPlaceService {

    private final PlaceRepository placeRepository;

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public Place getPlace(Long placeId) throws AllNotFoundException {
        return placeRepository.findById(placeId).orElseThrow(AllNotFoundException::new);
    }

    public void savePlace(Place place) {
        placeRepository.save(place);
    }

    public void deletePlace(Long placeId) {
        placeRepository.deleteById(placeId);
    }


}
