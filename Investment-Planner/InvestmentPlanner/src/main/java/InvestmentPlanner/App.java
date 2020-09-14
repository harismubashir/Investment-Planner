package InvestmentPlanner;

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
    public static void main(String[] args) {

        HttpResponse<String> httpResponse = Unirest.get(
                "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo")
                .asString();
        System.out.println(httpResponse.getBody()); // TODO: parse the json

        Login loginForm = new Login();
        loginForm.show();

    }
}
