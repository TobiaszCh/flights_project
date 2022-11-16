package com.project.flights.repository;

import com.project.flights.domain.Dates;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DatesRepository extends CrudRepository<Dates, Long> {

    @Override
    List<Dates> findAll();

    @Override
    Optional<Dates> findById(Long id);


}
