package zeh.challenge.movies.domain.winners.models.responses;

import lombok.Data;
import zeh.challenge.movies.domain.movies.models.beans.Movie;

import java.util.List;

@Data
public class GetWinnerDetailed {
    private long id;

    private boolean isWinner;

    private List<Movie> movies;
}
