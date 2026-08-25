class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if( temp.next[index] == null){
                temp.next[index] = new Node();
            }
            temp = temp.next[index];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(temp.next == null || temp.next[index] == null){
                return false;
            }
            temp = temp.next[index];
        }
        return temp.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for(char c : prefix.toCharArray()){
            int index = c - 'a';
            if(temp.next == null || temp.next[index] == null){
                return false;
            }
            temp = temp.next[index];
        }
        return true;
    }
    private static class Node {
        Node[] next = new Node[26];
        boolean isEnd = false;
        Node(){}
    }
}
