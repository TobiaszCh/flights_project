package com.project.flights.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "PLACES")
@NoArgsConstructor
@AllArgsConstructor
public class Place {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "PLACE_ID")
    private String id;

    @Column(name = "CONTINENT")
    private String continent;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String City;

    @OneToMany(
            targetEntity = Flight.class,
            mappedBy = "place",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Flight> flights = new ArrayList<>();
}
