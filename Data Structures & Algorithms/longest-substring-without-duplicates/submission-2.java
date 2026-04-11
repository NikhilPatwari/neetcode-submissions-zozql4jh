class Solution {
    public int lengthOfLongestSubstring(String str) {
        if(str.isEmpty()){
            return 0;
        }
        int res = 1, l = 0, r = 1,n = str.length();
        Set<Character> s = new HashSet<>();
        s.add(str.charAt(l));
        while(r < n){
            char c = str.charAt(r);
            if(s.contains(c)){
                while(str.charAt(l) != c){
                    s.remove(str.charAt(l));
                    l++;
                }
                l++;
            }else{
                res = Math.max(res, r-l+1);
            }
            s.add(c);
            r++;
            
        }
        return res;
        
    }
}
