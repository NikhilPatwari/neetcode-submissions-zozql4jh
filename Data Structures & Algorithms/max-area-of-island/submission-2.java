class Solution {
    int maxArea = Integer.MIN_VALUE;
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
         int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, dfs(grid, visited, i, j));
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || visited[i][j]
            || grid[i][j] != 1) {
            return 0;
        }
        visited[i][j] = true;
        return 1
          + dfs(grid, visited, i + 1, j)
          + dfs(grid, visited, i - 1, j)
          + dfs(grid, visited, i, j + 1)
          + dfs(grid, visited, i, j - 1);
    }
}
