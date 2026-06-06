class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        char[][] numberChars = new char[][] {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
        };
        dfs(res, digits, 0, new StringBuilder(), numberChars);
        return res;
    }
    private void dfs(
        List<String> res, String digits, int i, StringBuilder subset, char[][] numberChars) {
        if (i >= digits.length()) {
            res.add(subset.toString());
            return;
        }
        int digit = digits.charAt(i) - '0';
        char[] chars = numberChars[digit - 2];
        for (char c : chars) {
            subset.append(c);
            dfs(res, digits, i + 1, subset, numberChars);
            subset.deleteCharAt(subset.length() - 1);
        }
    }
}
