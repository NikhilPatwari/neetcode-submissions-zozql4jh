class Solution {
    Integer[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new Integer[m][n];

        return uniquePaths(0, 0, m, n);
    }
    public int uniquePaths(int i, int j, int m, int n) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        return dp[i][j] = uniquePaths(i + 1, j, m, n) + uniquePaths(i, j + 1, m, n);
    }
}
