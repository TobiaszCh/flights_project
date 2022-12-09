package com.project.flights.controller;

import com.project.flights.domain.dto.WeatherDto;
import com.project.flights.exceptions.AllNotFoundException;
import com.project.flights.service.DbWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    public final DbWeatherService dbweatherService;

    @GetMapping(value = "{city}")
    public ResponseEntity<WeatherDto> getWeather(@PathVariable String city) throws AllNotFoundException {
        return ResponseEntity.ok(dbweatherService.getWeatherForCity(city));
    }
}
