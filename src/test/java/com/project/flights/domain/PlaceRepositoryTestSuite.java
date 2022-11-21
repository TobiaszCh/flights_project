package com.project.flights.domain;

import com.project.flights.repository.PlaceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PlaceRepositoryTestSuite {

    @Autowired
    private PlaceRepository placeRepository;

    @Test
    public void testFindAllPlace() {
        //Given
        Place place = new Place();
        Place place1 = new Place();
        //When
        placeRepository.save(place);
        placeRepository.save(place1);
        //Then
        assertEquals(2, placeRepository.findAll().size());
        //Clean
        placeRepository.deleteAll();
    }

    @Test
    public void testFindPlaceById() {
        //Given
        Place place = new Place();
        //When
        placeRepository.save(place);
        Long id = place.getId();
        Optional<Place> foundCart = placeRepository.findById(id);
        //Then
        assertEquals(foundCart.get().getId(), id);
        //Clean
        placeRepository.deleteAll();
    }

    @Test
    public void testSavePlaceById() {
        //Given
        Place place = new Place();
        //When
        placeRepository.save(place);
        Long id = place.getId();
        Optional<Place> foundCart = placeRepository.findById(id);
        //Then
        assertTrue(foundCart.isPresent());
        //Clean
        placeRepository.deleteAll();
    }

    @Test
    public void testDeletePlaceById() {
        //Given
        Place dates = new Place();
        //When
        placeRepository.save(dates);
        placeRepository.delete(dates);
        Long id = dates.getId();
        Optional<Place> foundCart = placeRepository.findById(id);
        //Then
        assertFalse(foundCart.isPresent());
    }
}
