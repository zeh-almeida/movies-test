package zeh.challenge.movies.domain.input.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zeh.challenge.movies.domain.winners.models.beans.Winning;
import zeh.challenge.movies.domain.winners.repositories.WinnerRepository;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class InputPersistenceService {

    @Autowired
    private WinnerRepository winnerRepository;

    @Transactional
    public void doLoad(final List<Winning> input) {
        this.winnerRepository.saveAll(input);
    }
}
