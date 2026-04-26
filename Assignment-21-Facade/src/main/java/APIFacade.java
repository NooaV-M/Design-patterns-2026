import org.json.simple.parser.ParseException;

import java.io.IOException;

public class APIFacade {
    JsonExtractor jsonExtractor = new JsonExtractor();
    JsonGetter jsonGetter = new JsonGetter();

    APIFacade(JsonGetter jsonGetter, JsonExtractor jsonExtractor) {
        this.jsonExtractor = jsonExtractor;
        this.jsonGetter = jsonGetter;
    }

    String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException, ParseException {
        String json = jsonGetter.getJsonFromApi(urlString);

        return jsonExtractor.extractJokeFromJson(json, attributeName);
    }
}
