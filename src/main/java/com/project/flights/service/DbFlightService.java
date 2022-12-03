package com.project.flights.service;

import com.project.flights.config.AdminConfig;
import com.project.flights.domain.Flight;
import com.project.flights.domain.Mail;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DbFlightService {

    private final FlightRepository flightRepository;
    private final SimpleEmailService simpleEmailService;
    private final AdminConfig adminConfig;

    public List<Flight> getAllFlight() {
        return flightRepository.findAll();
    }

    public Flight getFlight(Long flightId) throws AllNotFoundException {
        return flightRepository.findById(flightId).orElseThrow(AllNotFoundException::new);
    }

    public void saveFlight(Flight flight) {
        flightRepository.save(flight);
        simpleEmailService.send(Mail.builder()
                .mailTo(adminConfig.getAdminMail())
                .subject("Create Flight")
                .message("We have it :)").build());
    }

    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }
}
