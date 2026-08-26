class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDup(nums, res, new ArrayList<>(), 0);
        return res;  
    }
    public void subsetsWithDup(int[] nums, List<List<Integer>> res, List<Integer> subset, int i) {
        if(i >= nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        subsetsWithDup(nums, res, subset, i+1);
        subset.remove(subset.size()-1);
        while(i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }
        subsetsWithDup(nums, res, subset, i+1);
    }
}
