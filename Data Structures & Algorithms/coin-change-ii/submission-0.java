class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[amount + 1][coins.length + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return change(amount, coins, 0);
    }
    public int change(int amount, int[] coins, int i) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || i >= coins.length) {
            return 0;
        }
        if (dp[amount][i] != -1)
            return dp[amount][i];
        if (amount - coins[i] >= 0) {
            return dp[amount][i] =
                       change(amount, coins, i + 1) + change(amount - coins[i], coins, i);
        } else {
            return dp[amount][i] = change(amount, coins, i + 1);
        }
    }
}
