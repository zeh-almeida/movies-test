package zeh.challenge.movies.domain.commons.services;

import org.springframework.data.domain.Page;

import java.util.Optional;

public interface RestService<GetModel, GetDetailedModel> {

    Page<GetModel> getAll(final int pageNumber);

    Optional<GetDetailedModel> get(final long id);
}
