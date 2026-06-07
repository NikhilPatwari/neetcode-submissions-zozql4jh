class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = -1;
                } else if (grid[i][j] == 1) {
                    grid[i][j] = Integer.MAX_VALUE;
                } else {
                    grid[i][j] = 0;
                    q.offer(new Pair(i, j));
                }
            }
        }
        int dist = 1;
        while (!q.isEmpty()) {
            for (int i = q.size() - 1; i >= 0; i--) {
                Pair p = q.poll();
                addToQueue(grid, q, p.r + 1, p.c, ROWS, COLS, dist);
                addToQueue(grid, q, p.r - 1, p.c, ROWS, COLS, dist);
                addToQueue(grid, q, p.r, p.c + 1, ROWS, COLS, dist);
                addToQueue(grid, q, p.r, p.c - 1, ROWS, COLS, dist);
            }
            dist++;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == Integer.MAX_VALUE) {
                    return -1;
                }
                if (grid[i][j] != -1 && max < grid[i][j]) {
                    max = grid[i][j];
                }
            }
        }
        if(max == Integer.MIN_VALUE ){
            return 0;
        }
        return max;
    }
    private void addToQueue(
        int[][] grid, Queue<Pair> q, int i, int j, int ROWS, int COLS, int dist) {
        if (i < 0 || j < 0 || i >= ROWS || j >= COLS || grid[i][j] != Integer.MAX_VALUE) {
            return;
        }
        q.add(new Pair(i, j));
        grid[i][j] = dist;
    }
}
class Pair {
    public int r;
    public int c;
    public Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
