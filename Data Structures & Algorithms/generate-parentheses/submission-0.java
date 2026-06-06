class Solution {
    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        set.add("");
        for (int i = 0; i < n; i++) {
            Set<String> new_set = new HashSet<>();
            for (String s : set) {
                for (int j = 0; j < s.length() + 1; j++) {
                    StringBuilder sb = new StringBuilder(s);
                    sb.insert(j, "()");
                    new_set.add(sb.toString());
                }
            }
            set = new_set;
        }
        return new ArrayList<>(set);
    }
}
