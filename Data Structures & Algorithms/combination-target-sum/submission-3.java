class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(nums, target, new ArrayList<>(), res, 0);
        return res;
    }
    public void combinationSum(
        int[] nums, int target, List<Integer> temp, List<List<Integer>> res, int index) {
        if (target < 0 || index >= nums.length) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        combinationSum(nums, target - nums[index], temp, res, index);
        temp.remove(temp.size() - 1);
        combinationSum(nums, target, temp, res, index + 1);
    }
}
