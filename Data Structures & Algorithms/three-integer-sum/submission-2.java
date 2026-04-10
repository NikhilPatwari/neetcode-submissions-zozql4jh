class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); 
        Set<String> res = new HashSet<>();
       Arrays.sort(nums);
       for(int k = nums.length-1; k>=2; k--) {
        int target = 0 - nums[k], i= 0,j=k-1;
        while(i<j){
            if(nums[i]+nums[j] == target){
                List<Integer> l = new ArrayList<>();
                l.add(nums[i]);
                l.add(nums[j]);
                l.add(nums[k]);
                String s = nums[i]+""+nums[j]+""+nums[k];
                if(!res.contains(s)){
                    res.add(s);
                    result.add(l);
                }
                j--;
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
