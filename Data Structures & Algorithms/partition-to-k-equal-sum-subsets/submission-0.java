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
        return canPartition(nums, new int[k], 0, sum);
    }
    public boolean canPartition(int[] nums, int[] k, int i, int sum) {
        if (Arrays.stream(k).allMatch(l -> l == sum)) {
            return true;
        }
        if (i >= nums.length) {
            return false;
        }
        for (int j = 0; j < k.length; j++) {
            if (k[j] + nums[i] <= sum) {
                k[j] += nums[i];
                if (canPartition(nums, k, i + 1, sum))
                    return true;
                k[j] -= nums[i];
            }
            if (k[j] == 0)
                break;
        }
        return false;
    }
}