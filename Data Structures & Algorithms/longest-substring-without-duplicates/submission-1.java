class Solution {
    public int lengthOfLongestSubstring(String str) {
        if(str.isEmpty()){
            return 0;
        }
        int res = 1, l = 0, r = 1,n = str.length();
        Map<Character,Integer> s = new HashMap<>();
        s.put(str.charAt(l),l);
        while(r < n){
            char c = str.charAt(r);
            if(s.containsKey(c)){
                int temp = s.get(c);
                while(l<=temp){
                    s.remove(str.charAt(l));
                    l++;
                }
            }else{
                res = Math.max(res, r-l+1);
            }
            s.put(c,r);
            r++;
            
        }
        return res;
        
    }
}
