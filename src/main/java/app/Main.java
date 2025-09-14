package app;


import app.DTO.ActivityDTO;
import app.DTO.CityInfoDTO;
import app.DTO.WeatherWrapper;
import app.config.HibernateConfig;
import app.enums.ExerciseType;
import app.service.CityServices;
import app.service.DTOConverters;
import app.service.WeatherServices;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public class Main {

    private static EntityManagerFactory emf;

    public static void main(String[] args) {

        emf = HibernateConfig.getEntityManagerFactory();

        System.out.println("Activitylogger output >>>>");
        String city = "Rørvig";

        // ******* Fetch and convert CityInfo from https://open-meteo.com/en/docs/geocoding-api
        CityServices cityServices = new CityServices();
        Optional<CityInfoDTO> cityInfoDTO = cityServices.getCityInfo(city);

        // Extract latitude and longitude from the city to be used for weather location
        double latitude = cityInfoDTO.map(CityInfoDTO::getLatitude).orElse(0.0);
        double longitude = cityInfoDTO.map(CityInfoDTO::getLongitude).orElse(0.0);

        // ******* Fetch WeatherInfo from https://open-meteo.com/en/docs
        WeatherServices weatherServices = new WeatherServices();
        WeatherWrapper weatherWrapper = weatherServices.getCityWeatherInfo(latitude, longitude);

        // **** Convert city and weatherinfo and build the final ActivityDTO
        DTOConverters dtoConverters = new DTOConverters();
        ActivityDTO activityDTO = ActivityDTO.builder()
                .exerciseDate(LocalDate.of(2025, 9, 11))
                .duration(LocalTime.of(0,35))
                .distance(5750)
                .comment("Nice jog - suns out - guns out")
                .exerciseType(ExerciseType.JOGGING)
                .cityInfoDTO(cityInfoDTO.orElse(null))
                .weatherDTO(dtoConverters.fromWeatherWrapper(weatherWrapper))
                .build();

        // ***** Print out results - including a Google Map link
        System.out.println(activityDTO);
        if (activityDTO.getCityInfoDTO() != null) {
            System.out.println(activityDTO.getCityInfoDTO()
                    .getGoogleMapLink(10));
        }
    }
}
