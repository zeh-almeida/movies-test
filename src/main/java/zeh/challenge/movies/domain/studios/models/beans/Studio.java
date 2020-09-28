package zeh.challenge.movies.domain.studios.models.beans;

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
public class Studio {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(targetEntity = Movie.class, mappedBy = "studios", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

        final Studio studio = (Studio) o;
        return this.getName().equals(studio.getName());
    }

    public boolean addMovie(final Movie movie) {
        return this.getMovies().add(movie);
    }
}
