class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        sum = sum / k;
        boolean [] used = new boolean[nums.length];
        return canPartition(nums, used, 0, k, sum, 0);
    }
    public boolean canPartition(int [] nums, boolean[] used, int i, int k, int target, int sum) {
        if(k == 0){
            return true;
        }
        if(sum == target){
            return canPartition(nums, used, 0, k-1, target, 0);
        }
        if(i >= nums.length ){
            return false;
        }
        for(int j = i; j< nums.length; j++){
            if(!used[j] && sum+nums[j] <= target){
                used[j] = true;
                if(canPartition(nums, used, j+1, k, target, sum+nums[j])) return true;
                used[j] = false;
            }
        }
        return false;
    }
}