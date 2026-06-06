class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>());
        return res;
    }
    public void dfs(int[] nums, int index, List<List<Integer>> res, List<Integer> subset) {
        // terminating condition
        if (index >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        // choose val at index
        subset.add(nums[index]);
        dfs(nums, index + 1, res, subset);
        subset.remove(subset.size() - 1);
        for(int i = index + 1; i < nums.length; i++){
            if(nums[i] == nums[index]){
                index = i;
            }
        }
        dfs(nums, index + 1, res, subset);
    }
}
