class Solution {
    int[][][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        if(s1.length() +s2.length() != s3.length()){
            return false;
        }
        return isInterleave(s1,s2,s3,0,0,0);
        
    }
    public boolean isInterleave(String s1, String s2, String s3, int i, int j, int k) {
        if(i == s1.length() && j == s2.length() && k == s3.length()){
            return true;
        }
        if(dp[i][j][k] != 0) return dp[i][j][k] == 1;
        boolean canBeDone = false;
        if(i<s1.length() && s1.charAt(i) == s3.charAt(k)){
            canBeDone  = isInterleave(s1,s2,s3,i+1,j,k+1);
            if(canBeDone){
                dp[i][j][k] = 1;
                return canBeDone;
            }
        }
        if(j<s2.length() && s2.charAt(j) == s3.charAt(k)){
            canBeDone  = isInterleave(s1,s2,s3,i,j+1,k+1);
            if(canBeDone){
                dp[i][j][k] = 1;
                return canBeDone;
            }
        }
        dp[i][j][k] = -1;
        return false;
    }
}
