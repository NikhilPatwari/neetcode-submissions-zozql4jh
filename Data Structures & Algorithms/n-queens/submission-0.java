class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] arr : board) {
            Arrays.fill(arr, '.');
        }
        List<List<String>> res = new ArrayList<>();
        dfs(board, 0, res);
        return res;
    }
    private void dfs(char[][] board, int i, List<List<String>> res) {
        if (i >= board.length) {
            List<String> temp = new ArrayList<>();
            for (int k = 0; k < board.length; k++) {
                String s = "";
                for (int l = 0; l < board[k].length; l++) {
                    s += board[k][l];
                }
                temp.add(s);
            }
            res.add(temp);
            return;
        }
        for (int j = 0; j < board[i].length; j++) {
            if (noCollision(board, i, j)) {
                board[i][j] = 'Q';
                dfs(board, i + 1, res);
                board[i][j] = '.';
            }
        }
    }
    private boolean noCollision(char[][] board, int i, int j) {
        if (i == 0) {
            return true;
        }
        int k = i - 1;
        while (k >= 0) {
            if (board[k][j] == 'Q') {
                return false;
            }
            k--;
        }
        int l = j + 1;
        k = i - 1;
        while (k >= 0 && l < board[0].length) {
            if (board[k][l] == 'Q') {
                return false;
            }
            k--;
            l++;
        }
        l = j - 1;
        k = i - 1;
        while (k >= 0 && l >= 0) {
            if (board[k][l] == 'Q') {
                return false;
            }
            k--;
            l--;
        }
        return true;
    }
}
