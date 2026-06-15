class Solution {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        Set<Pair> visited = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res = Math.max(res, longestIncreasingPath(matrix, i, j, visited));
            }
        }
        return res;
    }
    public int longestIncreasingPath(int[][] matrix, int i, int j, Set<Pair> visited) {
        if (visited.contains(new Pair(i, j))) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        Pair p = new Pair(i, j);
        visited.add(p);
        int ans = 0;
        if (i + 1 < matrix.length && matrix[i][j] < matrix[i + 1][j]) {
            ans = Math.max(ans, longestIncreasingPath(matrix, i + 1, j, visited));
        }
        if (i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]) {
            ans = Math.max(ans, longestIncreasingPath(matrix, i - 1, j, visited));
        }
        if (j + 1 < matrix[i].length && matrix[i][j] < matrix[i][j + 1]) {
            ans = Math.max(ans, longestIncreasingPath(matrix, i, j + 1, visited));
        }
        if (j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]) {
            ans = Math.max(ans, longestIncreasingPath(matrix, i, j - 1, visited));
        }
        visited.remove(p);
        return dp[i][j] = 1 + ans;
    }
}
class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pair other = (Pair) obj;
        return this.i == other.i && this.j == other.j;
    }
    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
