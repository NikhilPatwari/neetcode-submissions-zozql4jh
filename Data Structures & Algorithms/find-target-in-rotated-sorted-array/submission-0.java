class Solution {
    public int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);
        if(minIndex == 0){
            return find(nums,target, 0, nums.length-1);
        }else{
            int left = find(nums,target, 0, minIndex-1);
            if(left != -1){
                return left;
            }
            return find(nums,target, minIndex, nums.length-1);
        }

    }
    public int find(int[] nums, int target, int l, int r){
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m]  == target) {
                return m;
            } else if(nums[m] > target){
                r = m-1;
            }else{
                l = m + 1;
            }
        }
        return -1;
    }
    public int findMinIndex(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1, ans = nums[0], m;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (nums[m] < nums[0]) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
