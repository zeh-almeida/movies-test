package zeh.challenge.movies.domain.movies.models.beans;

import lombok.*;
import zeh.challenge.movies.domain.producers.models.beans.Producer;
import zeh.challenge.movies.domain.studios.models.beans.Studio;
import zeh.challenge.movies.domain.winners.models.beans.Winning;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    private Long id;

    private int year;

    private String title;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "producer_movie",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "producer_id", referencedColumnName = "id"))
    private Set<Producer> producers;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "studio_movie",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "studio_id", referencedColumnName = "id"))
    private Set<Studio> studios;

    @OneToOne(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Winning winning;

    @Override
    public int hashCode() {
        return Objects.hash(this.getYear(), this.getTitle());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        final Movie movie = (Movie) o;
        return this.getYear() == movie.getYear() &&
                this.getTitle().equals(movie.getTitle());
    }
}
