class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int r = heights.length, c = heights[0].length;
        boolean[][] visited = new boolean[r][c];
        Pair[][] res = new Pair[r][c];
        for (int i = 0; i < r; i++) {
            dfs(i, 0, heights, visited, res, true, false);
        }
        for (int j = 0; j < c; j++) {
            dfs(0, j, heights, visited, res, true, false);
        }
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            dfs(i, c-1, heights, visited, res, false, true);
        }
        for (int j = 0; j < c; j++) {
            dfs(r-1, j, heights, visited, res, false, true);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <r; i++) {
            for (int j = 0; j < c; j++) {
                if(res[i][j] != null && res[i][j].isPacific && res[i][j].isAtlantic){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i); temp.add(j);
                    result.add(temp);
                }
            }
        }
        return result;
    }
    private void dfs(int i, int j, int[][] grid, boolean[][] visited, Pair[][] res, 
    boolean isPacific,boolean isAtlantic) {
        int r = grid.length;
        int c = grid[0].length;
        visited[i][j] = true;
        if(res[i][j] == null){
            res[i][j] = new Pair(false, false);
        }
        res[i][j].isPacific = res[i][j].isPacific || isPacific;
        res[i][j].isAtlantic = res[i][j].isAtlantic || isAtlantic;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            if (i + dir[0] >= 0 && j + dir[1] >= 0 && i + dir[0] < r && j + dir[1] < c
                && !visited[i+dir[0]][j+dir[1]] && grid[i][j] <= grid[i + dir[0]][j + dir[1]]) {
                dfs(i + dir[0], j + dir[1], grid, visited, res, isPacific, isAtlantic);
            }
        }
    }

    private static class Pair {
        public boolean isPacific = false;
        public boolean isAtlantic = false;
        Pair(boolean a, boolean b) {
            this.isPacific = a;
            this.isAtlantic = b;
        }
    }
}
