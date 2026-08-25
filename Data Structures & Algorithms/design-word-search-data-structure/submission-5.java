class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new Node();
            }
            temp = temp.children[index];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        return search(word,0, root);
    }
    private boolean search(String word,int k, Node temp) {
        for (int i = k; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                boolean isPresent = false;
                for (int j = 0; j < 26; j++) {
                    if (temp.children[j] != null) {
                        isPresent = isPresent
                            || search(word,i + 1, temp.children[j]);
                        if (isPresent) {
                            return true;
                        }
                    }
                }
                return isPresent;

            } else {
                int index = c - 'a';
                if (temp.children[index] == null) {
                    return false;
                }
                temp = temp.children[index];
            }
        }
        return temp.isEnd;
    }
    private static class Node {
        boolean isEnd = false;
        Node[] children = new Node[26];
    }
}
