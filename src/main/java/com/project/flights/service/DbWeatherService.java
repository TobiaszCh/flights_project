package com.project.flights.service;

import com.project.flights.client.weather.WeatherClient;
import com.project.flights.domain.dto.WeatherDto;
import com.project.flights.exceptions.AllNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbWeatherService {

    private final WeatherClient weatherClient;

    public WeatherDto getWeatherForCity(String city) {
        return Optional.of(weatherClient.getWeather(city)).orElseThrow(AllNotFoundException::new);

    }
}
