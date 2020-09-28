package zeh.challenge.movies.domain.studios.models.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import zeh.challenge.movies.domain.studios.models.beans.Studio;
import zeh.challenge.movies.domain.studios.models.responses.GetStudio;
import zeh.challenge.movies.domain.studios.models.responses.GetStudioDetailed;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudioMapper {

    GetStudio toGetDto(final Studio source);

    GetStudioDetailed toGetDetailedDto(final Studio source);
}
