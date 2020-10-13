package InvestmentPlanner;

import java.util.ArrayList;

//import com.google.gson.JsonElement;

//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;

//import kong.unirest.HttpResponse;
//import kong.unirest.Unirest;

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

        Database.plans = new ArrayList<Plan>();
        Database.stocks = new ArrayList<Stock>();

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
