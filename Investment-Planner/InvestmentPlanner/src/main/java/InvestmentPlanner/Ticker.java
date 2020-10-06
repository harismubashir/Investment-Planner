package InvestmentPlanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.google.gson.JsonElement;

import com.google.gson.JsonParser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class Ticker {

    public void show(Mode mode, Plan plan) {

        JFrame pickForm = new JFrame();
        int rowHeight = 200;

        JButton addDeleteButton = new JButton((mode == Mode.CREATING) ? "Add" : "Delete");
        JLabel tickerLabel = new JLabel("Stock Name");
        JTextField tickerTextField = new JTextField("Stock Ticker", 30);

        JLabel noOfStocksLabel = new JLabel("No of Stocks");
        JTextField noOfStocksTextField = new JTextField("", 30);
        noOfStocksTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tickerTextField.setText("");
            }
        });

        addDeleteButton.setBounds(75, 150, 100, 40);
        tickerLabel.setBounds(50, 25, 100, 40);
        tickerTextField.setBounds(150, 25, 100, 40);

        noOfStocksLabel.setBounds(50, 75, 100, 40);
        noOfStocksTextField.setBounds(150, 75, 100, 40);

        pickForm.setName("Select Investment");

        pickForm.add(tickerLabel);
        pickForm.add(tickerTextField);

        pickForm.add(noOfStocksLabel);
        pickForm.add(noOfStocksTextField);

        pickForm.add(addDeleteButton);

        pickForm.setSize(400, 500);
        pickForm.setLayout(null);
        pickForm.setVisible(true);

        addDeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                final String[] tickerSearchResult = stockInfo(tickerTextField.getText());

                JTextField stockTextField = new JTextField(tickerSearchResult[0] + "  " + tickerSearchResult[1], 30);
                stockTextField.setBounds(150, rowHeight + 40, 100, 40);
                pickForm.add(stockTextField);
                plan.totalFunds = plan.totalFunds
                        + Double.parseDouble(tickerSearchResult[1]) * Double.parseDouble(noOfStocksTextField.getText());
                System.out.println(plan.totalFunds);
            }

        }

        );

    }

    public String[] stockInfo(String ticker) {

        String[] stockData = new String[4];

        final String stockApi = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=" + ticker
                + "&interval=5min&apikey=XIME2HD6DHN7WPYZ";
        final HttpResponse<String> httpResponse = Unirest.get(stockApi).asString();
        JsonElement e = JsonParser.parseString(httpResponse.getBody());

        final String stockCurrentPrice = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + ticker
                + "&apikey=XIME2HD6DHN7WPYZ";
        final HttpResponse<String> httpResponse2 = Unirest.get(stockCurrentPrice).asString();
        JsonElement e2 = JsonParser.parseString(httpResponse2.getBody());

        // System.out.println(e);
        String symbol = e.getAsJsonObject().get("Meta Data").getAsJsonObject().get("2. Symbol").getAsString();
        String price = e2.getAsJsonObject().get("Global Quote").getAsJsonObject().get("05. price").getAsString();
        System.out.println(symbol);
        System.out.println(price);

        stockData[0] = symbol;
        stockData[1] = price;

        return stockData;

    }

}