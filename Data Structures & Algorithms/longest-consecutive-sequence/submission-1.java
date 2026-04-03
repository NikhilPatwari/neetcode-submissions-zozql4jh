class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null){
            return 0;
        }else if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return 1;
        }
        Arrays.sort(nums);
        int max = 1;
        int chainLength = 1;
        int prev = nums[0];
        for(int i = 1; i< nums.length; i++){
            if(nums[i] == prev){

            }
            else if(nums[i] == prev +1) {
                chainLength ++;
                if(max < chainLength){
                    max = chainLength;
                }
            }else{
                chainLength = 1;
            }
            prev = nums[i];
        }
        return max;
    }
}
