package zeh.challenge.movies.domain.interval.models.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WinnerProducer {
    private String producerName;

    private int winningYear;
}
