package com.project.flights.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CARRIERS")
@NoArgsConstructor
@AllArgsConstructor
public class Carrier {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "CARRIER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(
            targetEntity = Flight.class,
            mappedBy = "carrier",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Flight> flights = new ArrayList<>();
}
