package app.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherDTO {
    private String time;
    private int interval;
    private double temperature;
    private double windspeed;
    private int winddirection;
    private int weathercode;
}
