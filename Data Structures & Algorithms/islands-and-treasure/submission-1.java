class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length, dist = 0;
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new Pair(i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            for (int i = q.size() - 1; i >= 0; i--) {
                Pair p = q.poll();
                addToQueue(grid, q, p.row + 1, p.col, ROWS, COLS, dist + 1);
                addToQueue(grid, q, p.row - 1, p.col, ROWS, COLS, dist + 1);
                addToQueue(grid, q, p.row, p.col + 1, ROWS, COLS, dist + 1);
                addToQueue(grid, q, p.row, p.col - 1, ROWS, COLS, dist + 1);
            }
            dist++;
        }
    }
    public void addToQueue(
        int[][] grid, Queue<Pair> q, int i, int j, int ROWS, int COLS, int dist) {
        if (i < 0 || i >= ROWS || j < 0 || j >= COLS || grid[i][j] != Integer.MAX_VALUE) {
            return;
        }
        q.offer(new Pair(i, j));
        grid[i][j] = dist;
    }
}
class Pair {
    public int row;
    public int col;
    public Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
