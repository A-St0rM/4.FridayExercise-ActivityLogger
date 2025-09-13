package app.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityInfoWrapper {
    @JsonProperty("results")
    private List<CityInfoDTO> results = Collections.emptyList(); // when "results" is missing
}
