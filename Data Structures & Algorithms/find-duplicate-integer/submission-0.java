class Solution {
    public int findDuplicate(int[] nums) {
        // hashmap
        // sort and then find repeat by reaidn adjacent value
        // xor - no
        // modify the array to put the value in its original position
        int i = 0;
        while(i < nums.length) {
            int index = nums[i] - 1;
            if(i == index){
                i++;
            }else if(nums[index] == nums[i]){
                return nums[i];
            }else{
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
        return 0;
    }
}
