package app.service;

import app.DTO.WeatherWrapper;

import java.util.Locale;

public class WeatherServices {

    private ApiServices apiServices = new ApiServices();
    private JsonToDTOConverters jsonToDTOConverters = new JsonToDTOConverters();

    public WeatherWrapper getCityWeatherInfo(double latitude, double longitude){
        String uri = String.format(Locale.ROOT,"https://api.open-meteo.com/v1/forecast?latitude=%.5f&longitude=%.5f&current_weather=true",latitude, longitude);
        String json = apiServices.fetchFromApi(uri);
        return jsonToDTOConverters.toWeatherInfoDTO(json);
    }
}