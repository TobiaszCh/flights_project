package com.project.flights.scheduler;

import com.project.flights.config.AdminConfig;
import com.project.flights.domain.Mail;
import com.project.flights.repository.*;
import com.project.flights.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@RequiredArgsConstructor
public class EmailScheduler {

    private static final String SUBJECT = "Once a day email";
    private final SimpleEmailService simpleEmailService;
    private final FlightRepository flightRepository;
    private final TicketRepository ticketRepository;
    private final PlaceRepository placeRepository;
    private final DatesRepository datesRepository;
    private final CarrierRepository carrierRepository;
    private final AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {

        long sizeFlight = flightRepository.count();
        long sizeTicket = ticketRepository.count();
        long sizePlace = placeRepository.count();
        long sizeDates = datesRepository.count();
        long sizeCarrier = carrierRepository.count();

        simpleEmailService.send(Mail.builder()
                .mailTo(adminConfig.getAdminMail())
                .subject(SUBJECT)
                .message("Currently in databases you got: " + sizeFlight + " flights, "
                + sizeTicket + " tickets, " + sizePlace + " places, " + sizeDates
                + sizeCarrier + " carriers, " + sizeDates + " dates.").build());
    }
}

