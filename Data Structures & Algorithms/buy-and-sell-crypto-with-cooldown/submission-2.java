class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][2];
        for (int[] a : dp) {
            Arrays.fill(a, -5000);
        }
        return maxProfit(prices, 0, 1);
    }
    public int maxProfit(int[] prices, int i, int buy) {
        if (i >= prices.length) {
            return 0;
        }
        if (dp[i][buy] != -5000) {
            return dp[i][buy];
        }
        if (buy == 1) {
            return dp[i][buy] = Math.max(
                       maxProfit(prices, i + 1, 0) - prices[i], maxProfit(prices, i + 1, 1));
        } else {
            return dp[i][buy] = Math.max(
                       prices[i] + maxProfit(prices, i + 2, 1), maxProfit(prices, i + 1, 0));
        }
    }
}
