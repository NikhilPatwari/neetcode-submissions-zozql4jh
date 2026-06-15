class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length+1][2];
        return maxProfit(prices,0,1);
    }
    public int maxProfit(int[] prices, int i, int buy) {
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][buy] != null){
            return dp[i][buy];
        }
        if(buy == 1) {
            return dp[i][buy] = Math.max(maxProfit(prices,i+1, 0) - prices[i],maxProfit(prices,i+1, 1));
        }else{
            return dp[i][buy] = Math.max(prices[i] + maxProfit(prices,i+2, 1), maxProfit(prices,i+1, 0));
        }
    }
}
