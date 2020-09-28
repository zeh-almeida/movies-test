package zeh.challenge.movies.domain.movies.models.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import zeh.challenge.movies.domain.movies.models.beans.Movie;
import zeh.challenge.movies.domain.movies.models.responses.GetMovie;
import zeh.challenge.movies.domain.movies.models.responses.GetMovieDetailed;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper {

    GetMovie toGetDto(final Movie source);

    GetMovieDetailed toGetDetailedDto(final Movie source);
}
