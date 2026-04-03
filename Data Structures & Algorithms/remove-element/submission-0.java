class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int last = nums.length -1;
        while(start  < nums.length && start <= last){
            if(nums[start] == val) {
                nums[start] = nums[last];
                nums[last] = val;
                last --;
                if(nums[start] != val){
                    start ++;
                }
            }else{
                start++;
            }
        }
        return start;
    }
}