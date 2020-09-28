package zeh.challenge.movies.domain.movies.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import zeh.challenge.movies.domain.movies.models.beans.Movie;

import java.util.Optional;

public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {

    Optional<Movie> findByYearAndTitle(final int year, final String title);
}
