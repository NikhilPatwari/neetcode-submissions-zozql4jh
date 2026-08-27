class Solution {
    Node root = new Node();
    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String a : wordDict) {
            add(a);
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        wordBreak(s, 0, sb, root, res);
        return res;
    }
    public void wordBreak(String s, int i, StringBuilder sb, Node t, List<String> res) {
        if (i == s.length()) {
            if (t.isEnd) {
                res.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(i);
        int index = c - 'a';
        if (t.children[index] == null) {
            return;
        }
        t = t.children[index];
        sb.append(c);
        if (t.isEnd && i + 1 != s.length()) {
            sb.append(' ');
            wordBreak(s, i + 1, sb, root, res);
            sb.deleteCharAt(sb.length() - 1);
            wordBreak(s, i + 1, sb, t, res);
        } else {
            wordBreak(s, i + 1, sb, t, res);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
    private void add(String s) {
        Node temp = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (temp.children[index] == null) {
                temp.children[index] = new Node();
            }
            temp = temp.children[index];
        }
        temp.isEnd = true;
    }
    private static class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
        Node() {}
    }
}