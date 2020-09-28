package zeh.challenge.movies.domain.producers.models.beans;

import lombok.*;
import zeh.challenge.movies.domain.movies.models.beans.Movie;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producer {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(targetEntity = Movie.class, mappedBy = "producers", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Movie> movies;

    @Override
    public int hashCode() {
        return Objects.hash(this.getName());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        final Producer producer = (Producer) o;
        return this.getName().equals(producer.getName());
    }

    public void addMovie(final Movie movie) {
        this.getMovies().add(movie);
    }
}
