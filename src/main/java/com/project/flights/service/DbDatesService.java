package com.project.flights.service;

import com.project.flights.domain.Dates;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.repository.DatesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbDatesService {

    private final DatesRepository datesRepository;

    public List<Dates> getAllDates() {
        return datesRepository.findAll();
    }

    public Dates getDates(Long datesId) throws AllNotFoundException {
        return datesRepository.findById(datesId).orElseThrow(AllNotFoundException::new);
    }

    public void saveDates(Dates dates) {
        datesRepository.save(dates);
    }

    public void deleteDates(Long datesId) {
        datesRepository.deleteById(datesId);
    }
}
