class PrefixTree {
    public TrieNode[] nodes;

    public PrefixTree() {
        this.nodes = new TrieNode[26];
    }

    public void insert(String word) {
        TrieNode [] nodes = this.nodes;
        TrieNode lastNode = new TrieNode();
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (nodes[index] == null) {
                nodes[index] = new TrieNode(c);
                lastNode = nodes[index];
                nodes = nodes[index].nodes;
            }else{
                lastNode = nodes[index];
                nodes = nodes[index].nodes;
            }
        }
        lastNode.isWordEnd = true;
    }

    public boolean search(String word) {
        TrieNode[] nodes = this.nodes;
        TrieNode lastNode = new TrieNode();
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (nodes[index] == null) {
                return false;
            }
            lastNode = nodes[index];
            nodes = nodes[index].nodes;

        }
        return lastNode.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode[] nodes = this.nodes;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (nodes[index] == null) {
                return false;
            }
            nodes = nodes[index].nodes;
        }
        return true;
    }
}

public class TrieNode {
    public char val;
    public TrieNode[] nodes;
    public boolean isWordEnd;
    public TrieNode(char val) {
        this.val = val;
        this.nodes = new TrieNode[26];
        this.isWordEnd = false;
    }

    public TrieNode() {
        this.nodes = new TrieNode[26];
    }
}
