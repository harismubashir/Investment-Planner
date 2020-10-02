package InvestmentPlanner;

import java.util.Date;

/**
 * Accepts planName as a string which is the the name entered by user Returns
 * details of the plan in String in the following order [0] Name of plan [1]
 * Total funds in plan (currency with upto 2 decimal places) [2] Recurring
 * Contribution (currency with upto two decimal places) [3] Risk tolerance
 * (number between 1-5 with 5 being high risk tolerance)
 * 
 * @param string[]
 * 
 */
public class Plan {
    public String name = "Haris";
    public Double totalFunds = 20000.0;
    public Double recurringContribution = 1000.0;
    public int riskTolerance = 5;
    public Date dateObj = new Date();


}
