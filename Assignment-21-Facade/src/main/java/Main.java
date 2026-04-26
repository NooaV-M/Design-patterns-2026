import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        JsonExtractor jsonExtractor = new JsonExtractor();
        JsonGetter jsonGetter = new JsonGetter();
        APIFacade apiFacade = new APIFacade(jsonGetter, jsonExtractor);

        System.out.println(apiFacade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value"));
        System.out.println(apiFacade.getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "id"));
        System.out.println(apiFacade.getAttributeValueFromJson("https://api.fxratesapi.com/latest", "rates"));
        System.out.println(apiFacade.getAttributeValueFromJson("https://api.chucknorris.io/joke", "base"));
}
}
