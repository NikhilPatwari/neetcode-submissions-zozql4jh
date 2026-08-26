class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>>res = new ArrayList();
        combine(n, k,res,new ArrayList<>());
        return res;
    }

    public void combine(int n, int k, List<List<Integer>>res, List<Integer> subset ) {
        if(n == 0 && k == subset.size()){
            res.add(new ArrayList<>(subset));
        }else if(n <= 0 || subset.size() + n < k){
            return;
        }
        subset.add(n);
        combine(n-1, k,res,subset);
        subset.remove(subset.size()-1);
        combine(n-1, k,res,subset);
        
    }
}