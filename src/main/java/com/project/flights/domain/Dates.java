package com.project.flights.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "DATES")
@NoArgsConstructor
@AllArgsConstructor
public class Dates {

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

    public Dates(Long id, LocalDateTime departure, LocalDateTime arrival) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
    }
}

