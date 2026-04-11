class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++ ){
            if(map.containsKey(nums[i])){
                List<Integer> j = map.get(nums[i]);
                int a = j.get(j.size()-1);
                if(i-a <= k){
                    return true;
                }
                j.add(i);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(i);
                map.put(nums[i],l);
            }
            
        }
        return false;

    }
}