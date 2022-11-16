package com.project.flights.repository;

import com.project.flights.domain.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Long> {

    @Override
    List<Place> findAll();

    @Override
    Optional<Place> findById(Long id);
}
