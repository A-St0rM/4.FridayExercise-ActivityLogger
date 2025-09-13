package app.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Locale;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityInfoDTO {
    private String name;
    private double latitude;
    private double longitude;
    private int elevation;
    @JsonProperty("country_code")
    private String countryCode;
    private long population;
    private List<String> postcodes;

    public String getGoogleMapLink(int zoomLevel){
        return String.format(
                Locale.ROOT,
                "https://www.google.com/maps/place/%.6f,%.6f/@%.6f,%.6f,%dz",
                latitude, longitude, latitude, longitude, zoomLevel
        );
    }
}
