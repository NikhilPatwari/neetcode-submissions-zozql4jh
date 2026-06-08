class Solution {
    int [] dp;
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(nums,0);
    }

    public int rob(int[] nums, int start) {
        if(start >= nums.length ){
            return 0;
        }
        if(dp[start]!= -1) return dp[start];
        return dp[start] = Math.max(nums[start] + rob(nums,start+2),rob(nums,start+1));
    }

}
