package com.project.flights.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "DATES")
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
}
