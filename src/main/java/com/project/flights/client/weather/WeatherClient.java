package com.project.flights.client.weather;

import com.project.flights.client.weather.config.WeatherConfig;
import com.project.flights.client.weather.dto.OpenWeatherDto;
import com.project.flights.domain.dto.WeatherDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class WeatherClient {

    private final RestTemplate restTemplate;
    private final WeatherConfig weatherConfig;

    public WeatherDto getWeather(String city) {
        OpenWeatherDto openWeatherDto = restTemplate.getForObject(weatherConfig.getWeatherApiEndpoint()
                        + "weather?q={city}&appid=" + weatherConfig.getWeatherAppKey() + "&lang=pl&units=metric",
                OpenWeatherDto.class, city);
        return WeatherDto.builder()
                .temperature(openWeatherDto.getMain().getTemp())
                .pressure(openWeatherDto.getMain().getPressure())
                .humidity((openWeatherDto.getMain().getHumidity()))
                .windSpeed(openWeatherDto.getWind().getSpeed())
                .build();
    }
}
