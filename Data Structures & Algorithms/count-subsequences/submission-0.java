class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int [s.length()+1][t.length()+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return numDistinct(s,t,0,0);
    }
     public int numDistinct(String s, String t, int i, int j) {
        if(j == t.length()){
            return 1;
        }
        if(i >= s.length()) {
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = numDistinct(s,t,i+1,j) + numDistinct(s,t,i+1,j+1);
        }else{
            return dp[i][j] = numDistinct(s,t,i+1,j);
        }
    }
}
