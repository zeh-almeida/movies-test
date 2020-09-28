package zeh.challenge.movies.domain.studios.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import zeh.challenge.movies.domain.studios.models.beans.Studio;

import java.util.Optional;

public interface StudioRepository extends PagingAndSortingRepository<Studio, Long> {

    Optional<Studio> findByName(final String name);
}
