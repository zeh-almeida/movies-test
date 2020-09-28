package zeh.challenge.movies.domain.producers.models.responses;

import lombok.Data;
import zeh.challenge.movies.domain.movies.models.beans.Movie;

import java.util.List;

@Data
public class GetProducerDetailed {
    private long id;

    private String name;

    private List<Movie> movies;
}
