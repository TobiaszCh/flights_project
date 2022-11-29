package com.project.flights.service;

import com.project.flights.client.weather.WeatherClient;
import com.project.flights.domain.dto.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherDto getWeatherForCity() {
        return weatherClient.getWeather("Tokio");

    }
}
