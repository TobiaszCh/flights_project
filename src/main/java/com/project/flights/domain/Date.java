package com.project.flights.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "DATES")
@NoArgsConstructor
@AllArgsConstructor
public class Date {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "DATE_ID")
    private Long id;

    @Column(name = "DEPARTURE")
    private LocalDateTime departure;

    @Column(name = "ARRIVAL")
    private LocalDateTime arrival;

    @OneToMany(
            targetEntity = Flight.class,
            mappedBy = "date",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Flight> flights = new ArrayList<>();
}

