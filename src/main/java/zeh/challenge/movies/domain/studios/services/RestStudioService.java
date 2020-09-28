package zeh.challenge.movies.domain.studios.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import zeh.challenge.movies.domain.commons.Values;
import zeh.challenge.movies.domain.commons.services.RestService;
import zeh.challenge.movies.domain.studios.models.mapping.StudioMapper;
import zeh.challenge.movies.domain.studios.models.responses.GetStudio;
import zeh.challenge.movies.domain.studios.models.responses.GetStudioDetailed;
import zeh.challenge.movies.domain.studios.repositories.StudioRepository;

import java.util.Optional;

@Component
public class RestStudioService implements RestService<GetStudio, GetStudioDetailed> {

    @Autowired
    private Values constants;

    @Autowired
    private StudioMapper mapper;

    @Autowired
    private StudioRepository StudioRepository;

    public Page<GetStudio> getAll(final int pageNumber) {
        final Pageable page = PageRequest.of(pageNumber, this.constants.getPageSize(), Sort.by("name"));
        return this.StudioRepository.findAll(page).map(model -> this.mapper.toGetDto(model));
    }

    public Optional<GetStudioDetailed> get(final long id) {
        return this.StudioRepository.findById(id).map(model -> this.mapper.toGetDetailedDto(model));
    }
}
