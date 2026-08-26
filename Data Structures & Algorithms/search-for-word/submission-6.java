class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean exists = false;
        for(int i = 0; i< board.length; i++){
            for(int j = 0 ; j< board[i].length; j++){
                exists = exists || exist(board, visited, i, j,word, "");
                if(exists){
                    return true;
                }
            }
        }
        return false;
        
    }
    public boolean exist(char[][] board, boolean [][] visited, int i, int j, String word, String s){
        if(s.length() < word.length()){
            if(!word.startsWith(s)){
                return false;
            }
        }else if(s.length() == word.length()){
            return s.equals(word);
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j]|| s.length() >  word.length() ){
            return false;
        }
        String n = s + board[i][j];
        visited[i][j] = true;
        boolean t =  exist(board, visited, i+1, j,word, n) ||
        exist(board, visited, i-1, j,word, n) ||
        exist(board, visited, i, j+1,word, n) ||
        exist(board, visited, i, j-1,word, n);
        visited[i][j] = false;
        return t;
    }
}
