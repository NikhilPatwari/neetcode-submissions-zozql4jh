class Solution {
    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length() + 1];
        return wordBreak(s, wordDict, 0);
    }
    public boolean wordBreak(String s, List<String> wordDict, int i) {
        if (i >= s.length()) {
            return true;
        }
        if (dp[i] != 0)
            return dp[i] == 1;
        for (String word : wordDict) {
            if (match(i, s, word)) {
                if (wordBreak(s, wordDict, i + word.length())) {
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[i] = -1;
        return false;
    }
    private boolean match(int i, String s, String word) {
        if (i + word.length() > s.length()) {
            return false;
        }
        int j = 0;
        while (j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}
