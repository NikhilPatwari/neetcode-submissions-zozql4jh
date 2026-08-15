class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0, m;
        for (int a : nums) {
            if (a > l)
                l = a;
        }
        int result = r;
        r = Math.min(nums.length, 50) * l;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (maxPartition(nums, k, m) <= k) {
                r = m - 1;
                result = m;
            } else {
                l = m + 1;
            }
        }
        return result;
    }
    public int maxPartition(int[] nums, int k, int limit) {
        int partition = 0;
        int temp = limit;
        for (int n : nums) {
            temp -= n;
            if (temp < 0) {
                partition++;
                temp = limit - n;
            }
        }
        if (temp >= 0) {
            partition++;
        }
        return partition;
    }
}