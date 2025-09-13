package app.service;

import app.DTO.CityInfoDTO;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class CityServices {

    private ApiServices apiServices = new ApiServices();
    private JsonToDTOConverters jsonToDTOConverters = new JsonToDTOConverters();

    public Optional<CityInfoDTO> getCityInfo(String city) {
        city = URLEncoder.encode(city, StandardCharsets.UTF_8);
        String uri = "https://geocoding-api.open-meteo.com/v1/search?name=" + city + "&count=1&language=en&format=json&countryCode=DK";
        String json = apiServices.fetchFromApi(uri);
        return jsonToDTOConverters.toCityInfoDTOs(json).getResults().stream().findFirst();
    }
}
