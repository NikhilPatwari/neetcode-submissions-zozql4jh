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
        char[] arr = word.toCharArray();
        for (int i = startIndex; i < arr.length; i++) {
            char c = arr[i];
            if (c == '.') {
                List<TrieNode> l = Arrays.stream(curr.children)
                                       .filter(Objects::nonNull)
                                       .collect(Collectors.toList());
                int finalI = i+1;
                return l.stream().anyMatch(x -> search(x, word, finalI));
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
