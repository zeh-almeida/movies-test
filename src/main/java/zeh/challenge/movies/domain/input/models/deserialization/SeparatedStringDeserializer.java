package zeh.challenge.movies.domain.input.models.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SeparatedStringDeserializer extends JsonDeserializer<List<String>> {

    private static final String SEPARATED_BY_COMMA = ", ";

    private static final String SEPARATED_BY_AND = " and ";

    @Override
    public List<String> deserialize(final JsonParser jsonParser, final DeserializationContext context) throws IOException {
        final JsonToken currentToken = jsonParser.getCurrentToken();
        final Set<String> result = new HashSet<>();

        if (currentToken.equals(JsonToken.VALUE_STRING)) {
            final String text = jsonParser.getText().trim();

            if (StringUtils.isEmpty(text)) {
                return this.getNullValue(context);

            } else {
                final String allContent = String.join(SEPARATED_BY_COMMA, text.split(SEPARATED_BY_AND));
                result.addAll(Arrays.stream(allContent.split(SEPARATED_BY_COMMA)).collect(Collectors.toList()));
            }

        } else if (currentToken.equals(JsonToken.VALUE_NULL)) {
            return this.getNullValue(context);
        }

        return new ArrayList<>(result);
    }
}