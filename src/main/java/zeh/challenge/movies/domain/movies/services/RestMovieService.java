package zeh.challenge.movies.domain.movies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import zeh.challenge.movies.domain.commons.Values;
import zeh.challenge.movies.domain.commons.services.RestService;
import zeh.challenge.movies.domain.movies.models.mapping.MovieMapper;
import zeh.challenge.movies.domain.movies.models.responses.GetMovie;
import zeh.challenge.movies.domain.movies.models.responses.GetMovieDetailed;
import zeh.challenge.movies.domain.movies.repositories.MovieRepository;

import java.util.Optional;

@Component
public class RestMovieService implements RestService<GetMovie, GetMovieDetailed> {

    @Autowired
    private Values constants;

    @Autowired
    private MovieMapper mapper;

    @Autowired
    private MovieRepository movieRepository;

    public Page<GetMovie> getAll(final int pageNumber) {
        final Pageable page = PageRequest.of(pageNumber, this.constants.getPageSize(),
                Sort.by("year").descending().and(Sort.by("title")));

        return this.movieRepository.findAll(page).map(model -> this.mapper.toGetDto(model));
    }

    public Optional<GetMovieDetailed> get(final long id) {
        return this.movieRepository.findById(id).map(model -> this.mapper.toGetDetailedDto(model));
    }
}
