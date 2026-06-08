class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        for(int i = 0; i<cost.length; i++){
            dp[i] = -1;
        }
        return Math.min(cost[0] + minCostClimbingStairs(cost,0),
            cost[1] + minCostClimbingStairs(cost,1));
        
    }
    public int minCostClimbingStairs(int[] cost, int start){
        if(start >= cost.length -2){
            return 0;
        }
        if(dp[start] != -1) return dp[start];
        return dp[start] = Math.min(cost[start + 1] + minCostClimbingStairs(cost,start+1),
            cost[start + 2] + minCostClimbingStairs(cost,start+2));
    }
}
