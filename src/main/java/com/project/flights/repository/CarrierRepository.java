package com.project.flights.repository;

import com.project.flights.domain.Carrier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarrierRepository extends CrudRepository<Carrier, Long> {

    @Override
    List<Carrier> findAll();


}
