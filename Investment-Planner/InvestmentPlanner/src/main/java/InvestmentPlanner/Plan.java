package InvestmentPlanner;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

    public String[] planData(String planName) {

        String[] data = new String[6];

        data[0] = planName;
        data[1] = "20000";
        data[2] = "1000";
        data[3] = "5";

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateObj = new Date();

        data[4] = df.format(dateObj.toString());

        FileReadWrite read = new FileReadWrite();

        String[] writeOk = read.readWrite(Mode.WRITE, data);
        data[5] = writeOk[0];

        return data;
    }

}
