class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(res, subset, 0, 0, nums, target);
        return res;
    }
    public void dfs(
        List<List<Integer>> res, List<Integer> subset, int sum, int i, int nums[], int target) {
        if (sum == target) {
            res.add(new ArrayList(subset));
            return;
        } else if (sum > target || i >= nums.length) {
            return;
        }
        sum += nums[i];
        subset.add(nums[i]);
        dfs(res, subset, sum, i, nums, target);
        sum -= nums[i];
        subset.remove(subset.size() - 1);
        dfs(res, subset, sum, i + 1, nums, target);
    }
}
