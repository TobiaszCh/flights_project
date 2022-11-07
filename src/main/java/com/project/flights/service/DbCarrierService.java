package com.project.flights.service;

import com.project.flights.domain.Carrier;
import com.project.flights.repository.CarrierRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbCarrierService {

    private final CarrierRepository carrierRepository;

    public List<Carrier> getAllTasks() {
        return carrierRepository.findAll();
    }

}
