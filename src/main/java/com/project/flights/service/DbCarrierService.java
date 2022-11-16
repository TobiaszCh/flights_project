package com.project.flights.service;

import com.project.flights.domain.Carrier;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.repository.CarrierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbCarrierService {

    private final CarrierRepository carrierRepository;

    public List<Carrier> getAllCarriers() {
        return carrierRepository.findAll();
    }

    public Carrier getCarrier(Long carrierId) throws AllNotFoundException {
        return carrierRepository.findById(carrierId).orElseThrow(AllNotFoundException::new);
    }

    public void saveCarrier(Carrier carrier) {
        carrierRepository.save(carrier);
    }

    public void deleteCarrier(Long carrierId) {
        carrierRepository.deleteById(carrierId);
    }
}
