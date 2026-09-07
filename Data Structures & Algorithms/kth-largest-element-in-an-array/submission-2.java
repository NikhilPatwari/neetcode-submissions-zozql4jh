class Solution {
    public int findKthLargest(int[] nums, int k) {
       return quickSelect(nums,0, nums.length -1,k);
        
    }
    public int quickSelect(int[] nums, int left, int right, int k){
        int elem = nums[right];
        int j = left;
        for(int i = left; i < right; i++){
            if(nums[i] <= elem){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        int temp = nums[j];
        nums[j] = elem;
        nums[right] = temp;
        if(j == nums.length - k){
            return nums[j];
        }else if(j > nums.length - k){
            return quickSelect(nums,left, j-1,k);
        }else{
            return quickSelect(nums,j+1, right,k);
        }
    }

}
