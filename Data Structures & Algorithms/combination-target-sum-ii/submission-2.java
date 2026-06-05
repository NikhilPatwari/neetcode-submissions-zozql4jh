class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, subset, 0, 0, nums, target);
        return res;
    }

    public void dfs(
            List<List<Integer>> res, List<Integer> subset, int sum, int i, int nums[], int target) {
        if (sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        } else if (sum > target || i >= nums.length) {
            return;
        }
        subset.add(nums[i]);
        dfs(res, subset, sum + nums[i], i+1, nums, target);
        subset.remove(subset.size() - 1);
        int temp = nums[i];
        while(i<nums.length && nums[i] == temp ) i++;
        dfs(res, subset, sum, i , nums, target);
    }
}
