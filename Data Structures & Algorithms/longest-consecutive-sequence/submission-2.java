class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int n : nums){
            s.add(n);
        }
        int lcs = 0;
        for(int n : nums){
            if(!s.contains(n-1)){
                int temp = n;
                int count = 0;
                while(s.contains(temp)){
                    count++;
                    temp++;
                }
                if(count>lcs){
                    lcs = count;
                }
            }
        }
        return lcs;
    }
}
