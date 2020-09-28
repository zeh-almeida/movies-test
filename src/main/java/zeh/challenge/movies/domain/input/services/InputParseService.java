package zeh.challenge.movies.domain.input.services;

import org.springframework.stereotype.Component;
import zeh.challenge.movies.domain.input.models.InputData;
import zeh.challenge.movies.domain.movies.models.beans.Movie;
import zeh.challenge.movies.domain.producers.models.beans.Producer;
import zeh.challenge.movies.domain.studios.models.beans.Studio;
import zeh.challenge.movies.domain.winners.models.beans.Winning;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class InputParseService {

    private static Set<Producer> parseProducers(final InputData input) {
        return input.getProducerNames()
                .stream()
                .map(name -> Producer.builder()
                        .name(name)
                        .movies(new HashSet<>())
                        .build())
                .collect(Collectors.toSet());
    }

    private static Set<Studio> parseStudios(final InputData input) {
        return input.getStudioNames()
                .stream()
                .map(name -> Studio.builder()
                        .name(name)
                        .movies(new HashSet<>())
                        .build())
                .collect(Collectors.toSet());
    }

    private static Movie parseMovie(final InputData input) {
        final Set<Producer> producers = parseProducers(input);
        final Set<Studio> studios = parseStudios(input);

        final Movie movie = Movie.builder()
                .title(input.getMovieTitle())
                .year(input.getMovieYear())
                .producers(producers)
                .studios(studios)
                .build();

        producers.forEach(p -> p.addMovie(movie));
        studios.forEach(p -> p.addMovie(movie));

        return movie;
    }

    private static Winning parseWinner(final InputData input) {
        final Movie movie = parseMovie(input);

        return Winning.builder()
                .movie(movie)
                .winner(input.isWinner())
                .year(input.getMovieYear())
                .build();
    }

    public List<Winning> parse(final List<InputData> data) {
        return data.stream().map(InputParseService::parseWinner).collect(Collectors.toList());
    }
}
