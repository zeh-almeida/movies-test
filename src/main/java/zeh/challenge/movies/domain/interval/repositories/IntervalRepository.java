package zeh.challenge.movies.domain.interval.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import zeh.challenge.movies.domain.interval.models.beans.WinnerProducer;
import zeh.challenge.movies.domain.producers.models.beans.Producer;

public interface IntervalRepository extends CrudRepository<Producer, Long> {

    @Query("SELECT" +
            " NEW zeh.challenge.movies.domain.interval.models.beans.WinnerProducer" +
            "(producers.name, winning.year)" +
            " FROM Winning winning" +
            " JOIN winning.movie movie" +
            " JOIN movie.producers producers" +
            " WHERE winning.winner = TRUE")
    Iterable<WinnerProducer> getWinningProducers();
}
