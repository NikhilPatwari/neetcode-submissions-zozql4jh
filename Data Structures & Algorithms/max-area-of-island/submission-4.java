class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, visited, i, j));
                }
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || visited[i][j]
            || grid[i][j] == 0) {
            return 0;
        }
        int count = 1;
        visited[i][j] = true;
        count += dfs(grid, visited, i + 1, j);
        count += dfs(grid, visited, i - 1, j);
        count += dfs(grid, visited, i, j + 1);
        count += dfs(grid, visited, i, j - 1);
        return count;
    }
}
