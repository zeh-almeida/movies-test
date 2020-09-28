package zeh.challenge.movies.domain.interval.services;

import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zeh.challenge.movies.domain.interval.models.beans.WinnerProducer;
import zeh.challenge.movies.domain.interval.repositories.IntervalRepository;

import java.util.Collection;

@Component
public class IntervalService {

    @Autowired
    private IntervalRepository intervalRepository;

    public Collection<WinnerProducer> getWinningProducers() {
        return IteratorUtils.toList(this.intervalRepository.getWinningProducers().iterator());
    }
}
