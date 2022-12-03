package com.project.flights.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity(name = "FLIGHTS")
@Getter
@Setter
@NoArgsConstructor
public class Flight {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "FLIGHT_ID")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "TICKET_ID")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "PLACE_ID")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "DATE_ID")
    private Dates date;

    @ManyToOne
    @JoinColumn(name = "CARRIER_ID")
    private Carrier carrier;

    public Flight(Ticket ticket, Place place, Dates date, Carrier carrier) {
        this.ticket = ticket;
        this.place = place;
        this.date = date;
        this.carrier = carrier;
    }
}
