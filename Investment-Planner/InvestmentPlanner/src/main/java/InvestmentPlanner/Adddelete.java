package InvestmentPlanner;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Adddelete {

    /**
     * Accepts mode.ADD, mode.DELETE Add options allows user to add stocks to their
     * portfolio Delete options allows user to delete existing stocks from portfolio
     * 
     * @param mode
     * 
     */
    public void show(Mode mode) {

        String portfolioFilePath = "C:\\Users\\Haris\\Desktop\\portfolio.txt";

        try {
            FileWriter fileWriter = new FileWriter(portfolioFilePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print("Portfolio Name");
            printWriter.printf("Stock Name", "SYMBOL", "price");
            printWriter.close();
        } catch (FileNotFoundException e1) {
        } catch (IOException e1) {

        }

    }

}