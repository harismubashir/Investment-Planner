package InvestmentPlanner;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Plan> plans;
    public static ArrayList<Stock> stocks;

    static Plan getPlanByNumber(int planNoRequested) throws Exception {

        for (int i = 0; i < plans.size(); i++) {

            if (Integer.valueOf(plans.get(i).index) == planNoRequested) {
                return plans.get(i);

            }

        }
        throw new Exception("Plan not found");
    }
}
