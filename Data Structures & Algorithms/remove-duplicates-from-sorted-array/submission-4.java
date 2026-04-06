class Solution {
    public int removeDuplicates(int[] nums) {
        int writePointer = 0, i = 0, n= nums.length;
        for(i = 0; i< n-1; i++){
            if(nums[i] != nums[i+1]){
                nums[writePointer] = nums[i];
                writePointer++;
            }
        }
        if(i == n-1 && nums[writePointer] != nums[i]){
                nums[writePointer] = nums[i];
        }
        return writePointer+1;
    }
}