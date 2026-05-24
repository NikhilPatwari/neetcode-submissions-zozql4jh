class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1, ans = nums[0], m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] < nums[0]) {
                ans = nums[m];
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}