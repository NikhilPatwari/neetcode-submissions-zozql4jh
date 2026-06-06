class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> sol = new LinkedList<>();
        res.add(sol);
        for(int i = 0; i< nums.length;i++ ){
            int size = res.size();
            List<List<Integer>> a = new LinkedList<>();
            for(List<Integer> l : res) {
                for(int j = 0; j < l.size()+1; j++){
                    List<Integer> temp = new LinkedList<>(l);
                    temp.add(j, nums[i]);
                    a.add(temp);
                }
            }
            res = a;
        }
        return res;
    }
}
