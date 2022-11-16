package com.project.flights.mapper;

import com.project.flights.domain.Ticket;
import com.project.flights.domain.dto.TicketDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketMapper {

    public Ticket mapToTicket(final TicketDto ticketDto) {
        return new Ticket(
                ticketDto.getId(),
                ticketDto.getKindOfPrice(),
                ticketDto.getPrice());
    }

    public TicketDto mapToTicketDto(final Ticket ticket) {
        return new TicketDto(
                ticket.getId(),
                ticket.getKindOfPrice(),
                ticket.getPrice());
    }

    public List<TicketDto> mapToTicketDtoList(List<Ticket> ticketList) {
        return ticketList.stream()
                .map(this::mapToTicketDto)
                .collect(Collectors.toList());
    }
}
