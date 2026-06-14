class Solution {
    int []dp;
    public int numDecodings(String s) {
        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        return numDecodings(s, 0);
    }

    public int numDecodings(String s, int i) {
        if(i == s.length()){
            return 1;
        }
        if(i >= s.length() || s.charAt(i) == '0') {
            return 0;
        }
        if(i >= s.length() -1) {
            return 1;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int count = 0;
        count +=  numDecodings(s, i+1);
        int firstDigit = s.charAt(i) -'0';
        int secondDigit = s.charAt(i+1) -'0';
        int num = (firstDigit*10)+secondDigit;
        if(num<=26){
            count+= numDecodings(s, i+2);
        }
        return dp[i] = count;        
    }
}
