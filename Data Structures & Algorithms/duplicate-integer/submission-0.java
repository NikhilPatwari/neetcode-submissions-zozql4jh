class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int a : nums){
            if(s.contains(a)){
                return true;
            }else{
                s.add(a);
            }
        }
        return false;
    }
}