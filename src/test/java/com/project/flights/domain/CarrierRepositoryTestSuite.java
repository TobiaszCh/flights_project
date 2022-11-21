package com.project.flights.domain;

import com.project.flights.repository.CarrierRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CarrierRepositoryTestSuite {

    @Autowired
    private CarrierRepository carrierRepository;

    @Test
    public void testFindAllCarriers() {
        //Given
        Carrier carrier = new Carrier();
        Carrier carrier1 = new Carrier();
        //When
        carrierRepository.save(carrier);
        carrierRepository.save(carrier1);
        //Then
        assertEquals(2, carrierRepository.findAll().size());
        //Clean
        carrierRepository.deleteAll();
    }

    @Test
    public void testFindCarrierById() {
        //Given
        Carrier carrier = new Carrier();
        //When
        carrierRepository.save(carrier);
        Long id = carrier.getId();
        Optional<Carrier> foundCart = carrierRepository.findById(id);
        //Then
        assertEquals(foundCart.get().getId(), id);
        //Clean
        carrierRepository.deleteAll();
    }

    @Test
    public void testSaveCarrierById() {
        //Given
        Carrier carrier = new Carrier();
        //When
        carrierRepository.save(carrier);
        Long id = carrier.getId();
        Optional<Carrier> foundCart = carrierRepository.findById(id);
        //Then
        assertTrue(foundCart.isPresent());
        //Clean
        carrierRepository.deleteAll();
    }

    @Test
    public void testDeleteCarrierById() {
        //Given
        Carrier carrier = new Carrier();
        //When
        carrierRepository.save(carrier);
        carrierRepository.delete(carrier);
        Long id = carrier.getId();
        Optional<Carrier> foundCart = carrierRepository.findById(id);
        //Then
        assertFalse(foundCart.isPresent());
    }
}
