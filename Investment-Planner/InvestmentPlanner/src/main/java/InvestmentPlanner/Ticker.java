package InvestmentPlanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.google.gson.JsonElement;

import com.google.gson.JsonParser;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class Ticker {

    public void show(Mode mode) {

        JFrame pickForm = new JFrame();

        JButton addDeleteButton = new JButton((mode == Mode.CREATING) ? "Add" : "Delete");
        JLabel tickerLabel = new JLabel("Stock Name");
        JTextField tickerTextField = new JTextField("Stock Ticker", 30);

        addDeleteButton.setBounds(75, 150, 100, 40);
        tickerLabel.setBounds(50, 25, 100, 40);
        tickerTextField.setBounds(150, 25, 100, 40);

        pickForm.setName("Select Investment");

        pickForm.add(tickerLabel);
        pickForm.add(tickerTextField);

        pickForm.add(addDeleteButton);

        pickForm.setSize(400, 500);
        pickForm.setLayout(null);
        pickForm.setVisible(true);

        addDeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                pickForm.setVisible(false);
            }

        }

        );

    }

    public String[] stockInfo(String ticker) {

        String[] stockData = new String[4];

        final String stockApi = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=demo";
        final HttpResponse<String> httpResponse = Unirest.get(stockApi).asString();
        JsonElement e = JsonParser.parseString(httpResponse.getBody());

        // System.out.println(e);
        String symbol = e.getAsJsonObject().get("Meta Data").getAsJsonObject().get("2. Symbol").getAsString();
        System.out.println(symbol);
        final Login loginForm = new Login();
        loginForm.show();

        return stockData;

    }

}