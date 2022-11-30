package com.project.flights.controller;

import com.project.flights.domain.dto.WeatherDto;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    public final WeatherService weatherService;

    @GetMapping(value = "{city}")
    public ResponseEntity<WeatherDto> getWeather(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getWeatherForCity(city));
    }

}
