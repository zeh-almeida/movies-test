package zeh.challenge.movies.domain.producers.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import zeh.challenge.movies.domain.producers.models.beans.Producer;

import java.util.Optional;

public interface ProducerRepository extends PagingAndSortingRepository<Producer, Long> {

    Optional<Producer> findByName(final String name);
}