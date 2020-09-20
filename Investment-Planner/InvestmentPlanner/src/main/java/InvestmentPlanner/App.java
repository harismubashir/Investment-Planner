package InvestmentPlanner;

import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

/**
 * Hello world!
 */
public final class App {

    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(final String[] args) {
        final String stockApi = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo";
        final HttpResponse<String> httpResponse = Unirest.get(stockApi).asString();
        JsonElement e = JsonParser.parseString(httpResponse.getBody());
        // System.out.println(e.getAsString(1));
        System.out.println(e);
        // parseJson();

        final Login loginForm = new Login();
        loginForm.show();

    }

    /**
     * Parses string to JSON
     *
     * @param apiUrl should be the url for the api being parsed
     */
    public static void parseJson() {

    }
}
