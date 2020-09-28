package zeh.challenge.movies.domain.winners.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import zeh.challenge.movies.domain.winners.models.beans.Winning;

import java.util.Optional;

public interface WinnerRepository extends PagingAndSortingRepository<Winning, Long> {

    Optional<Winning> findByYear(final int year);
}
