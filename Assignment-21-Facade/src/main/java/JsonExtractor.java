import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonExtractor {
    public String extractJokeFromJson(String json, String attribute) throws IllegalArgumentException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(json);

        Object value = jsonObject.get(attribute);
        if (value == null) {
            throw new IllegalArgumentException("Attribute not found in JSON: " + attribute);
        }

        // If the attribute is a nested object or array, return its JSON string representation
        if (value instanceof JSONObject || value instanceof JSONArray) {
            return value.toString();
        }

        // For primitives (String, Number, Boolean), return their string value
        return String.valueOf(value);
    }
}
