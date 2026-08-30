class Solution {
    public void solve(char[][] board) {
        int r = board.length, c = board[0].length;
        for (int i = 0; i < r; i += Math.max(r - 1, 1)) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    dfs(i, j, board);
                }
            }
        }
        for (int j = 0; j < c; j += Math.max(c - 1, 1)) {
            for (int i = 0; i < r; i++) {
                if (board[i][j] == 'O') {
                    dfs(i, j, board);
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    private void dfs(int i, int j, char[][] board) {
        board[i][j] = 'A';
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] dir : dirs) {
            if (i + dir[0] >= 0 && j + dir[1] >= 0 && i + dir[0] < board.length
                && j + dir[1] < board[0].length && board[i + dir[0]][j + dir[1]] == 'O') {
                dfs(i + dir[0], j + dir[1], board);
            }
        }
    }
}
