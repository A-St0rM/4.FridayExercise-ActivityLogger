package app.service;

import app.DTO.WeatherDTO;
import app.DTO.WeatherWrapper;

public class DTOConverters {
    public WeatherDTO fromWeatherWrapper(WeatherWrapper weatherWrapper){
        return WeatherDTO.builder()
                .temperature(weatherWrapper.getCurrentWeather().getTemperature())
                .elevation(weatherWrapper.getElevation())
                .latitude(weatherWrapper.getLatitude())
                .longitude(weatherWrapper.getLongitude())
                .timezone(weatherWrapper.getTimezone())
                .winddirection(weatherWrapper.getCurrentWeather().getWinddirection())
                .windspeed(weatherWrapper.getCurrentWeather().getWindspeed())
                .build();
    }
}
