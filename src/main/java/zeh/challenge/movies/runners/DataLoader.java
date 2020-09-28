package zeh.challenge.movies.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import zeh.challenge.movies.domain.input.models.InputData;
import zeh.challenge.movies.domain.input.services.InputParseService;
import zeh.challenge.movies.domain.input.services.InputPersistenceService;
import zeh.challenge.movies.domain.input.services.InputReadService;
import zeh.challenge.movies.domain.winners.models.beans.Winning;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private static final String DATA_PATH = "classpath:movielist.csv";

    @Autowired
    private InputPersistenceService persistanceService;

    @Autowired
    private InputParseService parseService;

    @Autowired
    private InputReadService inputService;

    @Transactional
    public void run(final ApplicationArguments args) {
        final List<InputData> inputs = this.inputService.read(DATA_PATH);
        final List<Winning> parsedData = this.parseService.parse(inputs);

        if (!parsedData.isEmpty()) {
            this.persistanceService.doLoad(parsedData);
        }
    }
}
