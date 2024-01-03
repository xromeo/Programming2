package easy;

import java.util.List;

public class MaximumCostLaptopCount {
    public static int maxCost(List<Integer> cost, List<String> labels, int dailyCount) {
        // Write your code here
        int n = cost.size();
        int dailyLegal = 0;
        int maxDailyCost = 0;
        int dailyCost = 0;
        int i = 0;
        while (i < n) {
            String label = labels.get(i);
            int costLaptop = cost.get(i);
            if ("legal".equals(label)) {
                dailyLegal++;
            }
            dailyCost += costLaptop;
            if (dailyLegal == dailyCount) {
                maxDailyCost = Math.max(maxDailyCost, dailyCost);
                dailyLegal = 0;
                dailyCost = 0;
            }
            i++;
        }
        return maxDailyCost;
    }

    public static void main(String[] args) {
        
    }
}
