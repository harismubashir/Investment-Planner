package InvestmentPlanner;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Plan> plans;
    public static ArrayList<Stock> stocks;

    static Plan getPlanByNumber(int select) throws Exception {

        for (int i = 0; i < plans.size(); i++) {

            if (Integer.valueOf(plans.get(i).planNo) == select) {
                return plans.get(i);

            }

        }
        throw new Exception("Plan not found");
    }
}
