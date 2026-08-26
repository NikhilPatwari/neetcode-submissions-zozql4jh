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
        }
        if (target - nums[index] == 0) {
            temp.add(nums[index]);
            res.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            combinationSum(nums, target, temp, res, index + 1);
            return;
        } else if (target - nums[index] > 0) {
            combinationSum(nums, target, temp, res, index + 1);
            temp.add(nums[index]);
            combinationSum(nums, target - nums[index], temp, res, index);
            temp.remove(temp.size() - 1);
        } else {
            combinationSum(nums, target, temp, res, index + 1);
        }
    }
}
