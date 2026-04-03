class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(h.getOrDefault(target - nums[i], -1) != -1){
                return new int[]{h.getOrDefault(target - nums[i], -1), i};
            }
            h.put(nums[i], i);
        }
        return new int[]{0,0};
    }
}
