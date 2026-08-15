class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length -1,m;
        if(nums[l] < nums[r]){
            return nums[l];
        }
        while(l<=r){
            m = l + (r-l)/2;
            if( m-1 >=0 && nums[m] < nums[m-1]){
                return nums[m];
            }else if(nums[m] >= nums[0]){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return nums[nums.length-1];
        
    }
}
