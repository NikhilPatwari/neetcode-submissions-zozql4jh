class Solution {
    Integer [] dp;
    public int minExtraChar(String s, String[] dictionary) {
        dp = new Integer[s.length() +1];
        return minExtraChar(s, 0, dictionary);
    }
    public int minExtraChar(String s, int i, String[] dictionary) {
        if (i >= s.length()) {
            return 0;
        }
        if(dp[i] != null){
            return dp[i];
        }
        if (!startsWith(s.charAt(i), dictionary)) {
            return dp[i] = 1 + minExtraChar(s, i + 1, dictionary);
        }
        int min = s.length() - i;
        for (int j = i; j < s.length(); j++) {
            if (isPresent(s, i, j, dictionary)) {
                min = Math.min(min, minExtraChar(s, j + 1, dictionary));
            }
        }
        return dp[i] = Math.min(min, 1 + minExtraChar(s, i + 1, dictionary));
    }

    public boolean startsWith(char c, String[] dictionary) {
        for (String s : dictionary) {
            if (s.charAt(0) == c) {
                return true;
            }
        }
        return false;
    }
    public boolean isPresent(String s, int i, int j, String[] dictionary) {
        for (String a : dictionary) {
            int len = j - i + 1;
            if (a.length() == len && isEquals(s, i, j, a)) {
                return true;
            }
        }
        return false;
    }
    public boolean isEquals(String s, int i, int j, String a) {
        int k = 0;
        while (i <= j) {
            if (s.charAt(i) != a.charAt(k)) {
                return false;
            }
            k++;
            i++;
        }
        return true;
    }
}