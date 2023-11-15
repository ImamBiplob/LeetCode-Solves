public class BuySellStock {
    public int maxProfit(int[] prices) {
        int leastSoFar = Integer.MAX_VALUE;
        int maxProfit = 0;
        int profitIfSoldToday = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < leastSoFar) {
                leastSoFar = prices[i];
            }
            profitIfSoldToday = prices[i] - leastSoFar;
            if (maxProfit < profitIfSoldToday) {
                maxProfit = profitIfSoldToday;
            }
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(prices[i], minPrice);
        }

        return maxProfit;
    }

    public int maxProfit3(int[] prices) {
        int sell = -1;
        int maxProfit = 0;

        for (int i = prices.length - 2; i >= 0; i--) {
            if (prices[i + 1] > sell) {
                sell = prices[i + 1];
            }

            if (sell - prices[i] > maxProfit) {
                maxProfit = sell - prices[i];
            }
        }

        return maxProfit;
    }

    public int maxProfitBestSol(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
    }
}
