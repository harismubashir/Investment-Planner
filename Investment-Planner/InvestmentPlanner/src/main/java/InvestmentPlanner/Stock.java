package InvestmentPlanner;

/**
 * Stores stockName (String), ticker (String), noOfStocks (int), purchasePrice
 * (double) date (Date) e.g. Tue Oct 06 17:09:21 NDT 2020 details of the plan in
 * String in the following order [0] Name of plan [1] Total funds in plan
 * (currency with upto 2 decimal places) [2] Recurring Contribution (currency
 * with upto two decimal places) [3] Risk tolerance (number between 1-5 with 5
 * being high risk tolerance)
 * 
 * @param string[]
 * 
 */
public class Stock {

    public String stockName;
    public String ticker;
    public int noOfStocks;
    public double purchasePrice;
    public String purchaseDateTime;
    public double totalInvestment;
    public double priceOneMonthAgo;
    public double priceTwoMonthsAgo;

    
}
