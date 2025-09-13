package app.DTO;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class WeatherDTO {
    private double latitude;
    private double longitude;
    private String timezone;
    private double elevation;
    private double temperature;
    private double windspeed;
    private int winddirection;
}