class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s,0,s.length() -1, true);
    }

    public boolean validPalindrome(String s,int start, int end, boolean allowDeletion) {
        int p1 = start, p2 = end;
        while(p1 < p2) {
            if(s.charAt(p1) != s.charAt(p2)){
                if(allowDeletion) {
                    allowDeletion = false;
                    return validPalindrome(s,p1,p2-1, false) || validPalindrome(s,p1+1,p2, false); 
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