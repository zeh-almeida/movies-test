package zeh.challenge.movies.domain.producers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import zeh.challenge.movies.domain.commons.Values;
import zeh.challenge.movies.domain.commons.services.RestService;
import zeh.challenge.movies.domain.producers.models.mapping.ProducerMapper;
import zeh.challenge.movies.domain.producers.models.responses.GetProducer;
import zeh.challenge.movies.domain.producers.models.responses.GetProducerDetailed;
import zeh.challenge.movies.domain.producers.repositories.ProducerRepository;

import java.util.Optional;

@Component
public class RestProducerService implements RestService<GetProducer, GetProducerDetailed> {

    @Autowired
    private Values constants;

    @Autowired
    private ProducerMapper mapper;

    @Autowired
    private ProducerRepository ProducerRepository;

    public Page<GetProducer> getAll(final int pageNumber) {
        final Pageable page = PageRequest.of(pageNumber, this.constants.getPageSize(), Sort.by("name"));
        return this.ProducerRepository.findAll(page).map(model -> this.mapper.toGetDto(model));
    }

    public Optional<GetProducerDetailed> get(final long id) {
        return this.ProducerRepository.findById(id).map(model -> this.mapper.toGetDetailedDto(model));
    }
}
