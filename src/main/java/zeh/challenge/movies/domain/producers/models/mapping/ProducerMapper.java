package zeh.challenge.movies.domain.producers.models.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import zeh.challenge.movies.domain.producers.models.beans.Producer;
import zeh.challenge.movies.domain.producers.models.responses.GetProducer;
import zeh.challenge.movies.domain.producers.models.responses.GetProducerDetailed;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProducerMapper {

    GetProducer toGetDto(final Producer source);

    GetProducerDetailed toGetDetailedDto(final Producer source);
}
