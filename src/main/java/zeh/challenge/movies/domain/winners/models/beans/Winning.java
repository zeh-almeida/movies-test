package zeh.challenge.movies.domain.winners.models.beans;

import lombok.*;
import zeh.challenge.movies.domain.movies.models.beans.Movie;

import javax.persistence.*;
import java.util.Objects;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Winning {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @MapsId
    private Movie movie;

    private boolean winner;

    private int year;

    @Override
    public int hashCode() {
        return Objects.hash(this.getYear(), this.isWinner());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        final Winning winning1 = (Winning) o;

        return this.isWinner() == winning1.isWinner() &&
                this.getYear() == winning1.getYear();
    }
}
