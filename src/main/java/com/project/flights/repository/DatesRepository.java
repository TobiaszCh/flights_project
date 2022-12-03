package com.project.flights.repository;

import com.project.flights.domain.Dates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatesRepository extends JpaRepository<Dates, Long> {


}
