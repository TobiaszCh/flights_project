package com.project.flights.controller;

import com.project.flights.domain.dto.WeatherDto;
import com.project.flights.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    public final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherDto getWeather() {
        return weatherService.getWeatherForCity();
    }


}
