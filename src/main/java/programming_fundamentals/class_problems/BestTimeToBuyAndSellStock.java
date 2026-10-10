package programming_fundamentals.class_problems;

public class BestTimeToBuyAndSellStock {

    static int maxProfit(int[] prices) {
        int lowestSoFar = Integer.MAX_VALUE;
        int best = 0;
        for (int price : prices) {
            if (price < lowestSoFar) {
                lowestSoFar = price;
            }
            int profitIfSoldToday = price - lowestSoFar;
            if (profitIfSoldToday > best) {
                best = profitIfSoldToday;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));   // 5
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));      // 0
    }
}
