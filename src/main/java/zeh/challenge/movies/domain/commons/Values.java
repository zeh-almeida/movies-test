package zeh.challenge.movies.domain.commons;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Values {

    @Value("${zeh.challenge.movies.pageSize}")
    private int pageSize;
}
