package app.DTO;

import app.enums.ExerciseType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Builder
@AllArgsConstructor
@ToString
@Getter
public class ActivityDTO {
    private LocalDate exerciseDate;
    private ExerciseType exerciseType;
    private LocalTime timeOfDay;
    private LocalTime duration;
    private int distance; // meters
    private String comment;
    CityInfoDTO cityInfoDTO;
    WeatherDTO weatherDTO;
}
