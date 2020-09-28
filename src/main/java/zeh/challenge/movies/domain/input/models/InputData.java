package zeh.challenge.movies.domain.input.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import zeh.challenge.movies.domain.input.models.deserialization.IsWinnerDeserializer;
import zeh.challenge.movies.domain.input.models.deserialization.SeparatedStringDeserializer;

import java.util.ArrayList;
import java.util.List;

@Data
public class InputData {
    @JsonProperty("year")
    private int movieYear;

    @JsonProperty("title")
    private String movieTitle;

    @JsonProperty("studios")
    @JsonDeserialize(using = SeparatedStringDeserializer.class)
    private List<String> studioNames;

    @JsonProperty("producers")
    @JsonDeserialize(using = SeparatedStringDeserializer.class)
    private List<String> producerNames;

    @JsonProperty(value = "winner", defaultValue = "false")
    @JsonDeserialize(using = IsWinnerDeserializer.class)
    private boolean isWinner;

    public InputData() {
        this.studioNames = new ArrayList<>();
        this.producerNames = new ArrayList<>();
    }
}
