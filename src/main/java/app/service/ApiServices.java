package app.service;

import app.exceptions.ApiException;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiServices {

    public String fetchFromApi(String Uri){

        HttpClient httpClient = HttpClient.newHttpClient();

        try {
            // Create a request
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(Uri)).GET().build();

            // Send request (get weather data)
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Check if the request went well
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                throw new ApiException(response.statusCode(), "Error in fetching");
            }
        } catch (Exception e){
            throw new ApiException(500, e.getMessage());
        }
    }

}
