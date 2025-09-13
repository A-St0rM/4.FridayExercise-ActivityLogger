package app.service;

import app.DTO.CityInfoWrapper;
import app.DTO.WeatherWrapper;
import app.exceptions.ApiException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToDTOConverters {

    private ObjectMapper objectMapper = new ObjectMapper();

    public WeatherWrapper toWeatherInfoDTO(String json){
        try {
            return objectMapper.readValue(json, WeatherWrapper.class);
        } catch (JsonProcessingException e) {
            throw new ApiException(500, e.getMessage());
        }
    }

    public CityInfoWrapper toCityInfoDTOs(String json){
        try {
            return objectMapper.readValue(json, CityInfoWrapper.class);
        } catch (JsonProcessingException e) {
            throw new ApiException(500, e.getMessage());
        }
    }
}