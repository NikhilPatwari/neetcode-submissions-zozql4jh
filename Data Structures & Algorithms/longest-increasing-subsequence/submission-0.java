class Solution {
    Map<String, Integer> dp;
    public int lengthOfLIS(int[] nums) {
        dp = new HashMap<>();
        return lengthOfLIS(nums, 0, Integer.MIN_VALUE);
    }
    public int lengthOfLIS(int[] nums, int i, int prev) {
        if (i == nums.length) {
            return 0;
        }
        String key = i + "," + prev;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (nums[i] > prev) {
            int res = Math.max(1 + lengthOfLIS(nums, i + 1, nums[i]), lengthOfLIS(nums, i + 1, prev));
            dp.put(key,res);
            return res;
        } else {
            int res = lengthOfLIS(nums, i + 1, prev);
            dp.put(key,res);
            return res;
        }
    }
}
