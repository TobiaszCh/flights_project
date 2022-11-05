package com.project.flights.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "TICKETS")
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "TICKET_ID")
    private Long id;

    @Column(name = "KIND_OF_PRICE")
    private String kindOfPrice;

    @Column(name = "PRICE")
    private double price;

}
