package zeh.challenge.movies.domain.winners.models.responses;

import lombok.Data;

@Data
public class GetWinner {
    private long id;

    private boolean isWinner;
}
