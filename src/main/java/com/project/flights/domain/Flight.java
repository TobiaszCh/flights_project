package com.project.flights.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FLIGHTS")
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "FLIGHT_ID")
    private int Id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TICKET_ID")
    private Ticket ticketList;

    @ManyToOne
    @JoinColumn(name = "PLACE_ID")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "DATE_ID")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "CARRIER_ID")
    private Carrier carrier;

}
