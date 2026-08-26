class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, n, new StringBuilder());
        return res;
    }
    public void generateParenthesis(int left, int right, StringBuilder sb) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
        } else if (right < left || left < 0 || right < 0) {
            return;
        }
        // choose left
        sb.append("(");
        generateParenthesis(left - 1, right, sb);
        sb.deleteCharAt(sb.length() - 1);
        
        // choose right
        sb.append(")");
        generateParenthesis(left, right - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
}
