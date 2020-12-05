package InvestmentPlanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.google.gson.JsonElement;

import com.google.gson.JsonParser;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import static javax.swing.JOptionPane.showMessageDialog;

public class Ticker {

    public String[] stockData = new String[4];
    JTable stocksTable;
    String[][] stocksListData;

    public void show(Mode mode, Plan plan) {

        JFrame pickForm = new JFrame();
        int rowHeight = 200;

        JButton buySellButton = new JButton((mode == Mode.CREATING) ? "Buy" : "Sell");
        JLabel tickerLabel = new JLabel("Stock Name");
        JTextField tickerTextField = new JTextField("Stock Ticker", 30);

        JButton searchButton = new JButton("Search");

        JLabel noOfStocksLabel = new JLabel("No of Stocks");
        JTextField noOfStocksTextField = new JTextField("", 30);

        searchButton.setBounds(75, 150, 100, 40);
        searchButton.setBounds(150, 150, 100, 40);
        tickerLabel.setBounds(50, 25, 100, 40);
        tickerTextField.setBounds(150, 25, 100, 40);
        buySellButton.setBounds(150, 200, 100, 30);

        noOfStocksLabel.setBounds(50, 75, 100, 40);
        noOfStocksTextField.setBounds(150, 75, 100, 40);

        pickForm.setName("Stocks List");

        pickForm.add(tickerLabel);
        pickForm.add(tickerTextField);

        pickForm.add(noOfStocksLabel);
        pickForm.add(noOfStocksTextField);

        pickForm.add(searchButton);

        pickForm.add(buySellButton);

        pickForm.setSize(400, 500);
        pickForm.setLayout(null);

        final JComboBox<String> stockDropdown = new JComboBox<String>();

        String[] columnNames = { "Stock", "Price", "Date", "Number" };

        if (mode == Mode.EDITING) {
            stocksListData = new String[plan.stocks.size()][4];
            for (int i = 0; i < plan.stocks.size(); i++) {
                stockDropdown.addItem(plan.stocks.get(i).stockName);
                stocksListData[i][0] = plan.stocks.get(i).stockName;
                stocksListData[i][1] = String.valueOf(plan.stocks.get(i).purchasePrice);
                stocksListData[i][2] = plan.stocks.get(i).purchaseDateTime;
                stocksListData[i][3] = String.valueOf(plan.stocks.get(i).noOfStocks);
            }

            stockDropdown.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tickerTextField.setText("You Selected : " + (stockDropdown.getSelectedItem()));
                }
            });

            stocksTable = new JTable(stocksListData, columnNames);
            stocksTable.setBounds(50, 250, 500, 20 * plan.stocks.size());
            stockDropdown.setBounds(150, 25, 100, 30);
            pickForm.remove(tickerTextField);
            pickForm.add(stocksTable);
            pickForm.add(stockDropdown);

        }

        pickForm.setVisible(true);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    System.out.println(stockDropdown.getSelectedItem());
                    final String[] tickerSearchResult = stockInfo((mode == Mode.CREATING) ? tickerTextField.getText()
                            : String.valueOf(stockDropdown.getSelectedItem()));

                    JTextField stockTextField = new JTextField(tickerSearchResult[0] + "  " + tickerSearchResult[1],
                            30);
                    stockTextField.setBounds(150, rowHeight + 40, 100, 40);
                    pickForm.add(stockTextField);
                    plan.totalFunds = plan.totalFunds + Double.parseDouble(tickerSearchResult[1])
                            * Double.parseDouble(noOfStocksTextField.getText());

                } catch (Exception ex) {
                    showMessageDialog(null, ex);
                }
            }

        }

        );

        buySellButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Stock stock = new Stock();
                stock.stockName = stockData[0];
                stock.purchasePrice = Double.valueOf(stockData[1]);
                stock.purchaseDateTime = stockData[2];

                if (mode == Mode.CREATING) {
                    plan.stocks.add(stock);
                    stock.noOfStocks = Integer.valueOf(noOfStocksTextField.getText());
                } else {
                    plan.stocks.add(Integer.valueOf(plan.planNo) + 1, stock);
                    stock.noOfStocks = Integer.valueOf(noOfStocksTextField.getText()) * -1;
                }

                stocksListData = new String[plan.stocks.size()][4];
                stocksListData[plan.stocks.size() - 1][0] = stockData[0];
                stocksListData[plan.stocks.size() - 1][1] = stockData[1];
                stocksListData[plan.stocks.size() - 1][2] = stockData[2];
                stocksListData[plan.stocks.size() - 1][3] = String.valueOf(stock.noOfStocks);
                if (stocksTable != null)
                    pickForm.remove(stocksTable);
                stocksTable = new JTable(stocksListData, columnNames);
                stocksTable.setBounds(50, 250, 500, 20 * plan.stocks.size());
                stockDropdown.setBounds(150, 25, 100, 30);
                pickForm.add(stocksTable);
                pickForm.repaint();

            }

        }

        );

    }

    public String[] stockInfo(String ticker) throws Exception {

        final String stockApi = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=" + ticker
                + "&interval=5min&apikey=XIME2HD6DHN7WPYZ";
        final HttpResponse<String> httpResponse = Unirest.get(stockApi).asString();
        JsonElement e = JsonParser.parseString(httpResponse.getBody());

        final String stockCurrentPrice = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol="
                + ticker + "&interval=5min&apikey=XIME2HD6DHN7WPYZ";

        final HttpResponse<String> httpResponse2 = Unirest.get(stockCurrentPrice).asString();
        JsonElement e2 = JsonParser.parseString(httpResponse2.getBody());

        // System.out.println(e);
        String symbol = e.getAsJsonObject().get("Meta Data").getAsJsonObject().get("2. Symbol").getAsString();
        if (httpResponse2.getBody().contains("Thank you for using Alpha Vantage!")) {
            throw new Exception("Please wait 1 minute");
        }
        String lastRefereshedTime = e2.getAsJsonObject().get("Meta Data").getAsJsonObject().get("3. Last Refreshed")
                .getAsString();
        String price = e2.getAsJsonObject().get("Time Series (5min)").getAsJsonObject().get(lastRefereshedTime)
                .getAsJsonObject().get("4. close").getAsString();
        System.out.println(symbol);
        System.out.println(lastRefereshedTime);
        System.out.println(price);

        stockData[0] = symbol;
        stockData[1] = price;
        stockData[2] = lastRefereshedTime;

        return stockData;

    }

    public void showList(Plan planList) {

    }

    public void updateList(Stock[] stocks) {
        if (stocksTable != null) {
            // remove stocksTable
        }

        /// stocksTable = new JTable(...)
    }

}