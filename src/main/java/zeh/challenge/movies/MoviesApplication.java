package zeh.challenge.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class MoviesApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }
}
