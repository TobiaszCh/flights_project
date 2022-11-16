package com.project.flights.repository;

import com.project.flights.domain.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {

    @Override
    List<Ticket> findAll();

    @Override
    Optional<Ticket> findById(Long id);
}
