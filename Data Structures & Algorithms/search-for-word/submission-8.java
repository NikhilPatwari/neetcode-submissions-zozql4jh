class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean exists = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                exists = exists || exist(board, visited, i, j, word, 0);
                if (exists) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean exist(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j]
            || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean t = exist(board, visited, i + 1, j, word, index+1)
            || exist(board, visited, i - 1, j, word, index+1) || exist(board, visited, i, j + 1, word, index+1)
            || exist(board, visited, i, j - 1, word, index+1);
        visited[i][j] = false;
        return t;
    }
}
