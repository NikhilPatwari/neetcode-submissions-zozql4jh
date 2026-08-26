class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, res, new ArrayList<>(), 0);
        return new ArrayList<List<Integer>>(res);
    }

    public void combinationSum(int[] candidates, int target, List<List<Integer>> res, List<Integer> subset, int index){
        if(target == 0){
            res.add(new ArrayList<>(subset));
            return;
        }else if(index >= candidates.length || target < 0){
            return;
        }
        subset.add(candidates[index]);
        combinationSum(candidates, target - candidates[index], res, subset, index+1);
        subset.remove(subset.size() -1);
        while(index + 1 < candidates.length && candidates[index] == candidates[index+1]){
            index++;
        }
        combinationSum(candidates, target, res, subset, index+1);
    }
}
