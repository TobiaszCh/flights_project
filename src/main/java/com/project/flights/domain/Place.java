package com.project.flights.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PLACES")
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
}
