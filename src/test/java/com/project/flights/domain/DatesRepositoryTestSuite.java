package com.project.flights.domain;

import com.project.flights.repository.DatesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DatesRepositoryTestSuite {

    @Autowired
    private DatesRepository datesRepository;

    @Test
    public void testFindAllDates() {
        //Given
        Dates dates = new Dates();
        Dates dates1 = new Dates();
        //When
        datesRepository.save(dates);
        datesRepository.save(dates1);
        //Then
        assertEquals(2, datesRepository.findAll().size());
        //Clean
        datesRepository.deleteAll();
    }

    @Test
    public void testFindDatesById() {
        //Given
        Dates dates = new Dates();
        //When
        datesRepository.save(dates);
        Long id = dates.getId();
        Optional<Dates> foundCart = datesRepository.findById(id);
        //Then
        assertEquals(foundCart.get().getId(), id);
        //Clean
        datesRepository.deleteAll();
    }

    @Test
    public void testSaveDatesById() {
        //Given
        Dates dates = new Dates();
        //When
        datesRepository.save(dates);
        Long id = dates.getId();
        Optional<Dates> foundCart = datesRepository.findById(id);
        //Then
        assertTrue(foundCart.isPresent());
        //Clean
        datesRepository.deleteAll();
    }

    @Test
    public void testDeleteDatesById() {
        //Given
        Dates dates = new Dates();
        //When
        datesRepository.save(dates);
        datesRepository.delete(dates);
        Long id = dates.getId();
        Optional<Dates> foundCart = datesRepository.findById(id);
        //Then
        assertFalse(foundCart.isPresent());
    }
}
