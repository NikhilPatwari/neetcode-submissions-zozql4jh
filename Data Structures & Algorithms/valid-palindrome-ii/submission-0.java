class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, true);
    }

    public boolean validPalindrome(String s, boolean allowReplacement) {
        int p1 = 0, p2 = s.length() - 1;
        while(p1 < p2){
            if(s.charAt(p1) != s.charAt(p2)){
                if(allowReplacement) {
                    allowReplacement = false;
                    return validPalindrome(s.substring(p1,p2), false) || validPalindrome(s.substring(p1+1,p2+1), false); 
                }
                return false;
            }else {
                p1++;
                p2 --;
            }
        }
        return true;
    }
}