class Solution {
    Integer [][] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount+1][coins.length+1];
        int coinChange =  coinChange(coins,amount,0);
        if(coinChange == Integer.MAX_VALUE || coinChange == Integer.MAX_VALUE -1 ){
            return -1;
        }
        return coinChange;
    }

    public int coinChange(int[] coins, int amount, int index) {
        if(index == coins.length){
            return Integer.MAX_VALUE -1;
        }else if(amount == 0){
            return 0;
        }
        if(dp[amount][index]!= null) return dp[amount][index];
        int exclude = coinChange(coins,amount,index +1);
        if(amount - coins[index] >= 0){
            int include = 1 + coinChange(coins,amount - coins[index],index);
                return dp[amount][index] = Math.min(include,exclude);
        }else{
            return dp[amount][index] = exclude;
        }
    }
}
