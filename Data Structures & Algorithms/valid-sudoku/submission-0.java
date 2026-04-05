class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i<9; i++) {
            for(int j = 0; j<9; j++) {
                if(board[i][j] != '.' && set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
            set.clear();
        }
        for(int i = 0; i<9; i++) {
            for(int j = 0; j<9; j++) {
                if(board[j][i] != '.' && set.contains(board[j][i])) {
                    return false;
                }
                set.add(board[j][i]);
            }
            set.clear();
        }
        for(int i = 0; i<9; i+=3) {
            for(int j = 0; j<9; j+=3) {
                for(int starti = i;starti < i+3; starti++){
                    for(int startj = j;startj < j+3; startj++){
                        if(board[starti][startj] != '.' && set.contains(board[starti][startj])) {
                            return false;
                        }
                        set.add(board[starti][startj]);
                    }
                }
                set.clear();
            }
        }
        return true;
    }
}
