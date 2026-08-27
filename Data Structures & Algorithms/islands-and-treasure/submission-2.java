class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int R = grid.length, C = grid[0].length;
        boolean[][] visited = new boolean[R][C];

        for(int i = 0; i< R; i++){
            for(int j = 0; j<C; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }
        int steps = 1;
        while(!q.isEmpty()){
            for(int k = q.size() -1; k>=0;k--){
                int [] temp = q.poll();
                int i = temp[0];
                int j = temp[1];
                // up
                if(i -1 >= 0 && grid[i-1][j] != -1 && grid[i-1][j] > steps){
                    grid[i-1][j] = steps;
                    q.offer(new int[]{i-1,j});
                }
                // down
                if(i + 1 < R && grid[i+1][j] != -1 && grid[i+1][j] > steps){
                    grid[i+1][j] = steps;
                    q.offer(new int[]{i+1,j});
                }
                // left
                if(j - 1 >= 0 && grid[i][j-1] != -1 && grid[i][j-1] > steps){
                    grid[i][j-1] = steps;
                    q.offer(new int[]{i,j-1});
                }
                // right
                if(j + 1 < C && grid[i][j+1] != -1 && grid[i][j+1] > steps){
                    grid[i][j+1] = steps;
                    q.offer(new int[]{i,j+1});
                }
            }
            steps++;
        }
        
    }
    
}
