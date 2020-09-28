package zeh.challenge.movies.domain.input.models.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AndStringDeserializer extends JsonDeserializer<List<String>> {

    private static final String SEPARATOR = " and ";

    @Override
    public List<String> deserialize(final JsonParser jsonParser, final DeserializationContext context) throws IOException {
        final JsonToken currentToken = jsonParser.getCurrentToken();
        final List<String> result = new ArrayList<>();

        if (currentToken.equals(JsonToken.VALUE_STRING)) {
            final String text = jsonParser.getText().trim();

            if (StringUtils.isEmpty(text)) {
                return this.getNullValue(context);

            } else {
                result.addAll(Arrays.stream(text.split(SEPARATOR))
                        .collect(Collectors.toList()));
            }

        } else if (currentToken.equals(JsonToken.VALUE_NULL)) {
            return this.getNullValue(context);
        }

        return result;
    }
}