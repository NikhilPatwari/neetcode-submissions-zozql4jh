class Solution {
    int[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum % 2 != 0) {
            return false;
        }
        dp = new int[nums.length + 1][sum / 2 + 1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return canPartition(nums, nums.length, sum / 2);
    }
    public boolean canPartition(int[] nums, int n, int sum) {
        if (n == 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (dp[n][sum] != -1)
            return dp[n][sum] == 1;
        if (sum - nums[n - 1] >= 0) {
            dp[n][sum] =
                (canPartition(nums, n - 1, sum) || canPartition(nums, n - 1, sum - nums[n - 1]))
                ? 1 : 0;
        } else {
            dp[n][sum] = canPartition(nums, n - 1, sum) ? 1 : 0;
        }
        return dp[n][sum] == 1;
    }
}
