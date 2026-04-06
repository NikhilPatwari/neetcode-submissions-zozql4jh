class Solution {
    public int[] twoSum(int[] nums, int target) {
        int p = 0;
        int q = nums.length -1;
        while(p<q){
            if(nums[p] + nums[q] == target){
                return new int[]{p+1,q+1};
            }else if(nums[p] + nums[q] > target) {
                q--;
            }else{
                p++;
            }
        }
        return new int[]{0,0};
    }
}
