class Solution {
    public void sortColors(int[] nums){
        int zeroEnd = -1;
        int twoStart = nums.length;
        int i = 0;
        while (i < nums.length && i < twoStart){
            if(nums[i] == 0 && i != zeroEnd){
                zeroEnd++;
                nums[i] = nums[zeroEnd];
                nums[zeroEnd] = 0;
            }else if(nums[i] == 2){
                twoStart--;
                nums[i] = nums[twoStart];
                nums[twoStart] = 2;
            }else{
                i++;
            }
        }
    }
}