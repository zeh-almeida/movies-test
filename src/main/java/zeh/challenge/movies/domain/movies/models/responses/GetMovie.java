package zeh.challenge.movies.domain.movies.models.responses;

import lombok.Data;

@Data
public class GetMovie {

    private long id;

    private int year;

    private String title;
}
