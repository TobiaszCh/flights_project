package com.project.flights.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}
