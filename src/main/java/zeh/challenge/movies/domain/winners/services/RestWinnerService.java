package zeh.challenge.movies.domain.winners.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import zeh.challenge.movies.domain.commons.Values;
import zeh.challenge.movies.domain.commons.services.RestService;
import zeh.challenge.movies.domain.winners.models.mapping.WinnerMapper;
import zeh.challenge.movies.domain.winners.models.responses.GetWinner;
import zeh.challenge.movies.domain.winners.models.responses.GetWinnerDetailed;
import zeh.challenge.movies.domain.winners.repositories.WinnerRepository;

import java.util.Optional;

@Component
public class RestWinnerService implements RestService<GetWinner, GetWinnerDetailed> {

    @Autowired
    private Values constants;

    @Autowired
    private WinnerMapper mapper;

    @Autowired
    private WinnerRepository movieRepository;

    public Page<GetWinner> getAll(final int pageNumber) {
        final Pageable page = PageRequest.of(pageNumber, this.constants.getPageSize(),
                Sort.by("year").descending().and(Sort.by("isWinner")));

        return this.movieRepository.findAll(page).map(model -> this.mapper.toGetDto(model));
    }

    public Optional<GetWinnerDetailed> get(final long id) {
        return this.movieRepository.findById(id).map(model -> this.mapper.toGetDetailedDto(model));
    }
}
