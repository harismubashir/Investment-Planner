package InvestmentPlanner;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

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
        System.out.println(httpResponse.getBody()); // TODO: parse the json

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

        JSONObject obj = new JSONObject();

        JSONArray arr = obj.getJSONArray(
                "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo");

        for (int i = 0; i < arr.length(); i++) {
            System.out.println(arr.getJSONObject(i));
        }

    }
}
