package com.project.flights.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "PLACES")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Place {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "PLACE_ID")
    private Long id;

    @Column(name = "CONTINENT")
    private String continent;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;

    @OneToMany(
            targetEntity = Flight.class,
            mappedBy = "place",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Flight> flights = new ArrayList<>();

    public Place(Long id, String continent, String country, String city) {
        this.id = id;
        this.continent = continent;
        this.country = country;
        this.city = city;
    }
}
