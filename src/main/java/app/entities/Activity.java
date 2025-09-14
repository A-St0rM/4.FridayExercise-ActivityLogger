package app.entities;

import app.enums.ExerciseType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate exerciseDate;
    private ExerciseType exerciseType;
    private LocalTime timeOfDay;
    private LocalTime duration;
    private int distance;
    private String comment;

    //Relations
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CityInfo cityInfoDTO;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private WeatherInfo weatherInfo;
}
