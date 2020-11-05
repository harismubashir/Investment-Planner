package InvestmentPlanner;

import java.util.ArrayList;

public class Database {
    public static ArrayList<Plan> plans;
    public static ArrayList<Stock> stocks;

    static Plan getPlanByNumber(String planNo) throws Exception {

        for (int i = 0; i < plans.size(); i++) {

            if (plans.get(i).planNo.equals(planNo)) {
                return plans.get(i);

            }

        }
        throw new Exception("Plan not found");
    }
}
