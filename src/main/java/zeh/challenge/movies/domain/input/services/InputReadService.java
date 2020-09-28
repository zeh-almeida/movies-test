package zeh.challenge.movies.domain.input.services;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import zeh.challenge.movies.domain.input.models.InputData;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class InputReadService {
    private static final CsvSchema BOOTSTRAP_SCHEMA = CsvSchema.emptySchema()
            .withHeader()
            .withColumnSeparator(';');

    @Autowired
    private ResourceLoader resourceLoader;

    public List<InputData> read(final String filePath) {
        try {
            final File file = this.performFileChecks(filePath);
            final CsvMapper mapper = new CsvMapper();

            final MappingIterator<InputData> readValues =
                    mapper.readerFor(InputData.class)
                            .with(BOOTSTRAP_SCHEMA)
                            .readValues(file);

            return readValues.readAll();

        } catch (final Exception e) {
            log.error(String.format("Error occurred while loading file %s", filePath), e);
            return Collections.emptyList();
        }
    }

    private File performFileChecks(final String filePath) throws IOException {
        if (StringUtils.isEmpty(filePath)) {
            throw new IllegalArgumentException("[filePath] cannot be null nor empty");
        }

        final Resource resource = this.resourceLoader.getResource(filePath);
        return resource.getFile();
    }
}
