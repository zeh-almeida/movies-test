package zeh.challenge.movies.domain.input.models.deserialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class IsWinnerDeserializer extends JsonDeserializer<Boolean> {

    private static final String NO = "no";

    private static final String YES = "yes";

    @Override
    public Boolean deserialize(final JsonParser jsonParser, final DeserializationContext context) throws IOException {
        final JsonToken currentToken = jsonParser.getCurrentToken();

        if (currentToken.equals(JsonToken.VALUE_STRING)) {
            final String text = jsonParser.getText().trim().toLowerCase();

            if (StringUtils.isEmpty(text) || NO.equals(text)) {
                return Boolean.FALSE;

            } else if (YES.equals(text)) {
                return Boolean.TRUE;
            }

            throw context.weirdStringException(text, Boolean.class,
                    String.format("Only \"%s\" or \"%s\" values supported", YES, NO));

        } else if (currentToken.equals(JsonToken.VALUE_NULL)) {
            return this.getNullValue(context);
        }

        return (Boolean) context.handleUnexpectedToken(Boolean.class, jsonParser);
    }

    @Override
    public Boolean getNullValue(final DeserializationContext context) {
        return Boolean.FALSE;
    }
}