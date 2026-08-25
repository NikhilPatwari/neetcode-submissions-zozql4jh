class Solution {
    Node root = new Node();
    public List<String> findWords(char[][] board, String[] words) {
        for(String s : words){
            addWord(s);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                StringBuilder sb = new StringBuilder();
                dfs(board, visited, i, j, res, root,sb);
            }
        }
        return res;
    }
    private void addWord(String s) {
        Node temp = root;
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new Node();
            }
            temp = temp.children[index];
        }
        temp.isEnd = true;
    }

    private void dfs(
        char[][] board, boolean[][] visited, int i, int j, List<String> res, Node temp, StringBuilder sb) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j] ) {
            return;
        }
        Node prev = temp;
        char c = board[i][j];
        int index = c - 'a';
        if(temp.children[index] == null){
            return;
        }
        sb.append(c);
        temp = temp.children[index];
        visited[i][j] = true;
        if (temp.isEnd) {
            res.add(sb.toString());
            temp.isEnd = false;
        }
        dfs(board, visited, i + 1, j, res,temp,sb);
        dfs(board, visited, i - 1, j, res,temp,sb);
        dfs(board, visited, i, j + 1, res,temp,sb);
        dfs(board, visited, i, j - 1, res,temp,sb);
        visited[i][j] = false;
        temp = prev;
        sb.deleteCharAt(sb.length()-1);
    }

    private static class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
    }
}
