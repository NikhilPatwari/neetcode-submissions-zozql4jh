class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        List<Character> subset = new ArrayList<>();
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
        dfs(res, digits, 0, subset, numberChars);
        return res;
    }
    private void dfs(
        List<String> res, String digits, int i, List<Character> subset, char[][] numberChars) {
        if (i >= digits.length()) {
            StringBuilder sb = new StringBuilder(subset.size());
            for (Character ch : subset) {
                sb.append(ch);
            }
            res.add(sb.toString());
            return;
        }
        int digit = digits.charAt(i) - '0';
        char[] chars = numberChars[digit - 2];
        for (char c : chars) {
            subset.add(c);
            dfs(res, digits, i + 1, subset, numberChars);
            subset.remove(subset.size() - 1);
        }
    }
}
