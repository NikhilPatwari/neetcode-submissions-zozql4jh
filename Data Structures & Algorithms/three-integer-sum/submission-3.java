class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); 
       Arrays.sort(nums);
       for(int k = nums.length-1; k>=2; k--) {
        int target = 0 - nums[k], i= 0,j=k-1;
        if(k < nums.length -1 && nums[k] == nums[k+1]){
            continue;
        }
        while(i<j){
            if(nums[i]+nums[j] == target){
                List<Integer> l = new ArrayList<>();
                l.add(nums[i]);
                l.add(nums[j]);
                l.add(nums[k]);
                result.add(l);
                j--;
                i++;
                while( i<j && nums[i]== nums[i-1]){
                    i++;
                }
            }else if(nums[i]+nums[j] > target){
                j--;
            }else{
                i++;
            }
        }
       }
       return result; 
    }
}
