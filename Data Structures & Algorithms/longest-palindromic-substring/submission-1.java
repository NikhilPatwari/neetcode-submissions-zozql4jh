class Solution {
    Pair[][] dp;
    public String longestPalindrome(String s) {
        dp = new Pair[s.length() + 1][s.length() + 1];
        Pair p = longestPalindrome(s, 0, s.length() - 1);
        return s.substring(p.a, p.b + 1);
    }
    public Pair longestPalindrome(String s, int start, int end) {
        if (start >= end) {
            return new Pair(0, 0);
        }
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        if (isPalindrome(s, start, end)) {
            return dp[start][end] = new Pair(start, end);
        } else {
            Pair p = longestPalindrome(s, start + 1, end);
            Pair q = longestPalindrome(s, start, end - 1);
            if (p.b - p.a > q.b - q.a) {
                return dp[start][end] = p;
            } else {
                return dp[start][end] = q;
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
class Pair {
    int a;
    int b;
    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
