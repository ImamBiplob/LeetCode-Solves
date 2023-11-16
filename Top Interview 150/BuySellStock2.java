public class BuySellStock2 {
    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;
        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - buyPrice > profit) {
                profit = prices[i] - buyPrice;
                totalProfit += profit;
                profit = 0;
                buyPrice = prices[i];
            }

            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
        }

        return totalProfit;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }
}
