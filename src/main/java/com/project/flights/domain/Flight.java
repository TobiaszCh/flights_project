package com.project.flights.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

}
