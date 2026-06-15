class Solution {
    int [][] dp;
    public int minDistance(String word1, String word2) {
        dp = new int [word1.length()+1][word2.length()+1];
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        return minDistance(word1, word2,0,0);
    }
    public int minDistance(String s, String t, int i, int j) {
        if(i >= s.length()) {
            return t.length() -j;
        }

        if(j >= t.length()) {
            return s.length() - i;
        }
        if(dp[i][j] !=-1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = minDistance(s,t,i+1, j+1);
        }else{
            int add = 1 + minDistance(s,t,i, j+1);
            int delete = 1 + minDistance(s,t,i+1, j);
            int replace = 1+ minDistance(s,t,i+1,j+1);
            return dp[i][j] = Math.min(add, Math.min(delete,replace));
        }
    }
}
