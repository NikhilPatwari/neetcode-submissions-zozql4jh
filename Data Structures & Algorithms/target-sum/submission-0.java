class Solution {
    Map<Integer, Map<Integer,Integer>> dp;
    public int findTargetSumWays(int[] nums, int target) {
        dp = new HashMap<>();
        return findTargetSumWays(nums,0, 0, target);
    }
    public int findTargetSumWays(int[] nums,int i,int sum, int target) {
        if(target == sum && i == nums.length) {
            return 1;
        }
        if(i >= nums.length){
            return 0;
        }
        if(dp.get(i) != null && dp.get(i).get(sum) != null){
            return dp.get(i).get(sum);
        }
        if(!dp.containsKey(i)) {
            dp.put(i, new HashMap<Integer, Integer>());
        }
        
        int ways = findTargetSumWays(nums, i+1, sum - nums[i], target) + findTargetSumWays(nums, i+1, sum + nums[i], target);  
        dp.get(i).put(sum, ways);
        return ways;      
    }
}
