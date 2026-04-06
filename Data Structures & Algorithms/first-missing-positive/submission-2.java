class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length, i = 0;
        while(i < n){
            if(nums[i] < 1 || nums[i] > n){
                i++;
            }else{
                int pos = nums[i] - 1;
                if(i == pos ){
                    i++;
                }else if(nums[i] == nums[pos]){
                    nums[i] = 0;
                    i++;
                }else{
                    int temp =nums[i];
                    nums[i] = nums[pos];
                    nums[pos] = temp;
                }
            }
        }
        for(i = 0; i<n; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }
}