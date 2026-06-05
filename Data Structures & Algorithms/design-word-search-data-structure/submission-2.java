class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode curr, String word, int startIndex) {
        for (int i = startIndex; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : curr.children) {
                    if (child != null && search(child,word, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    return false;
                }
                curr = curr.children[index];
            }
        }
        return curr.endOfWord;
    }
}
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}
