package zeh.challenge.movies.domain.movies.models.responses;

import lombok.Data;
import zeh.challenge.movies.domain.producers.models.beans.Producer;
import zeh.challenge.movies.domain.studios.models.beans.Studio;

import java.util.List;

@Data
public class GetMovieDetailed {

    private long id;

    private int year;

    private String title;

    private List<Producer> producers;

    private List<Studio> studios;
}
