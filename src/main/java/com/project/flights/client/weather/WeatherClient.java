package com.project.flights.client.weather;

import com.project.flights.client.weather.dto.OpenWeatherDto;
import com.project.flights.domain.dto.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class WeatherClient {

    private final RestTemplate restTemplate;
    private static String WEATHER_URL = "https://api.openweathermap.org/data/2.5/";
    private static String API_KEY = "4b1db59ca7fe3e1b61e372984581b2ad";

    public WeatherDto getWeather(String city) {
        OpenWeatherDto openWeatherDto = restTemplate.getForObject(WEATHER_URL + "weather?q={city}&appid={API_KEY}&lang=pl&units=metric",
                OpenWeatherDto.class, city, API_KEY);
        return WeatherDto.builder()
                .temperature(openWeatherDto.getMain().getTemp())
                .pressure(openWeatherDto.getMain().getPressure())
                .humidity((openWeatherDto.getMain().getHumidity()))
                .windSpeed(openWeatherDto.getWind().getSpeed())
                .build();

    }
}
