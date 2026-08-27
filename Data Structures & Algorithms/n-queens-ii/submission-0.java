class Solution {
    int count  = 0;
    public int totalNQueens(int n) {
        boolean [][] board = new boolean[n][n];
        nQueen(board, 0);
        return count;
    }
    public void nQueen(boolean [][] board, int row){
        if(row >= board.length){
            count++;
            return;
        }
        for(int j = 0; j< board.length; j++){
            if(canPlaceQueen(board,row,j)){
                board[row][j] = true;
                nQueen(board, row+1);
                board[row][j] = false;
            }
        }

    }
    public boolean canPlaceQueen(boolean [][] board, int row,int col){
        // verticle check
        int r = row,c = col;
        for(r = row; r>=0 ; r-- ){
            if(board[r][col]) return false;
        }
        r = row;
        c = col;
        for(; r >= 0 && c < board.length;){
            if(board[r][c]) return false;
            c++;
            r--;
        }
        r = row;
        c = col;
        for(; r >= 0 && c >=0;){
            if(board[r][c]) return false;
            c--;
            r--;
        }
        return true;
    }
}