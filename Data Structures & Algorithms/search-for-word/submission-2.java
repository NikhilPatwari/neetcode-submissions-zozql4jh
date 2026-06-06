class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[] isPresent = new boolean[] {false};
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, word, i, j, 0, isPresent, visited);
            }
        }
        return isPresent[0];
    }

    public void dfs(char[][] board, String word, int i, int j, int index, boolean[] isPresent,
        boolean[][] visited) {
        if (isPresent[0] || index >= word.length() || i < 0 || i >= board.length || j < 0
            || j >= board[i].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return;
        } else if (index == word.length() - 1) {
            isPresent[0] = true;
            return;
        }
        visited[i][j] = true;
        dfs(board, word, i + 1, j, index + 1, isPresent, visited);
        dfs(board, word, i - 1, j, index + 1, isPresent, visited);
        dfs(board, word, i, j + 1, index + 1, isPresent, visited);
        dfs(board, word, i, j - 1, index + 1, isPresent, visited);
        visited[i][j] = false;
    }
}
