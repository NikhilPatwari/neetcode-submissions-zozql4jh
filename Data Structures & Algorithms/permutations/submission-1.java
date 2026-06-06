class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> sol = new LinkedList<>();
        res.add(sol);
        for(int x : nums){
            List<List<Integer>> a = new LinkedList<>();
            for(List<Integer> l : res) {
                for(int j = 0; j < l.size()+1; j++){
                    List<Integer> temp = new LinkedList<>(l);
                    temp.add(j, x);
                    a.add(temp);
                }
            }
            res = a;
        }
        return res;
    }
}
