class Solution {
    Pair[][] dp;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // dfs
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        dp = new Pair[heights.length+1][heights[0].length+1];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                Pair p = dfs(i, j, heights, visited,Integer.MAX_VALUE);
                if(p != null && p.isPacific && p.isAtlantic){
                    List<Integer> t = new ArrayList<>();
                    t.add(i);
                    t.add(j);
                    res.add(t);
                }
            }
        }
        return res;
        // dp??
    }
    private Pair dfs(int i, int j, int[][] grid, boolean[][] visited, int prev) {

        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || j<0 || i >= m || j>= n || visited[i][j] || grid[i][j] > prev  ){
            return null;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if ((i == 0 && j == n - 1) || (i == m - 1 && j == 0)) {
            return dp[i][j] = new Pair(true, true);
        }
        
        boolean isPacific = false, isAtlantic = false;
        if(i == 0 || j == 0){
             isPacific = true;
        }else if(i == m-1 || j == n-1){
            isAtlantic = true;
        }
        visited[i][j] =true;
        Pair  p = dfs(i+1, j,grid,visited,grid[i][j]);
        if(p!= null){
            isPacific = isPacific || p.isPacific;
            isAtlantic = isAtlantic || p.isAtlantic;
            if(isPacific && isAtlantic){
                visited[i][j] =false;
                 return dp[i][j] = new Pair(true, true);
            }
        }
        p = dfs(i-1, j,grid,visited,grid[i][j]);
        if(p!= null){
            isPacific = isPacific || p.isPacific;
            isAtlantic = isAtlantic || p.isAtlantic;
            if(isPacific && isAtlantic){
                visited[i][j] =false;
                 return dp[i][j] =new Pair(true, true);
            }
        }
        p = dfs(i, j-1,grid,visited,grid[i][j]);
        if(p!= null){
            isPacific = isPacific || p.isPacific;
            isAtlantic = isAtlantic || p.isAtlantic;
            if(isPacific && isAtlantic){
                visited[i][j] =false;
                 return dp[i][j] =new Pair(true, true);
            }
        }
         p = dfs(i, j+1,grid,visited,grid[i][j]);
        if(p!= null){
            isPacific = isPacific || p.isPacific;
            isAtlantic = isAtlantic || p.isAtlantic;
            if(isPacific && isAtlantic){
                visited[i][j] =false;
                 return dp[i][j] =new Pair(true, true);
            }
        }
        visited[i][j] =false;
        return dp[i][j] =new Pair(isPacific, isAtlantic);
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
