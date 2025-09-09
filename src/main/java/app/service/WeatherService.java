package app.service;

import app.DTO.WeatherInfoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherService {

    private final HttpClient client = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1) // nødvendigt for DAWA
            .build();

    public WeatherInfoDTO getWeather(String city) throws Exception {
        String url = "https://vejr.eu/api.php?location=" + city + "&degree=C";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), WeatherInfoDTO.class);
    }



}
