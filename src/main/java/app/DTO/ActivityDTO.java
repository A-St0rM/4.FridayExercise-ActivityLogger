package app.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ActivityDTO {

    private LocalDate exerciseDate;
    private String  exerciseType;
    private String timeOfDay;
    private double duration;
    private double distance;
    private String comment;

    private WeatherInfoDTO weatherInfo;
    private CityInfoDTO cityInfo;
}
