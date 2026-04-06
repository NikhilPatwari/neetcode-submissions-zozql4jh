class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int DUPLICATE = 500;
        for(int i = 0; i< n-1; i++){
            if(nums[i] == nums[i+1]){
                nums[i] = DUPLICATE;
            }
        }
        for(int i = 0; i<n; i++){
            if(nums[i] == DUPLICATE){
                int nonDuplicateIndex = i+1;
                while(nonDuplicateIndex!= n && nums[nonDuplicateIndex] == DUPLICATE){
                    nonDuplicateIndex++;
                }
                if(nonDuplicateIndex == n) {
                    return i;
                }else{
                    nums[i] = nums[nonDuplicateIndex];
                    nums[nonDuplicateIndex] = DUPLICATE;
                }
            }
        }
        return n;
    }
    public int findFisrtNonDuplicatIndex(int startIndex, int[] nums, int DUPLICATE, int n){
        while(startIndex!= n && nums[startIndex] == DUPLICATE){
            startIndex++;
        }
        return startIndex;
    }
}