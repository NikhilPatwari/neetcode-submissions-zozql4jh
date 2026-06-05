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
        return search(root, word);
    }

    private boolean search(TrieNode curr, String word) {
        int i = 0;
        for (char c : word.toCharArray()) {
            i++;
            if (c == '.') {
                List<TrieNode> l = Arrays.stream(curr.children).filter(Objects::nonNull).collect(Collectors.toList());
                int finalI = i;
                return l.stream().anyMatch(x -> search(x, word.substring(finalI)));
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
