package zeh.challenge.movies.domain.winners.models.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import zeh.challenge.movies.domain.winners.models.beans.Winning;
import zeh.challenge.movies.domain.winners.models.responses.GetWinner;
import zeh.challenge.movies.domain.winners.models.responses.GetWinnerDetailed;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WinnerMapper {

    GetWinner toGetDto(final Winning source);

    GetWinnerDetailed toGetDetailedDto(final Winning source);
}
