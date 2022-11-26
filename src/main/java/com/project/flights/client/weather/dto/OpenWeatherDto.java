package com.project.flights.client.weather.dto;

import lombok.Getter;

@Getter
public class OpenWeatherDto {

    private OpenWeatherWindDto wind;
    private OpenWeatherMainDto main;
}
