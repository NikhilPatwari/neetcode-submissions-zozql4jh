class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for (int l = 0; l < s.length(); l++) {
            char c = s.charAt(l);
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (st.peek() != '[') {
                   sb.append(st.pop());
                }
                sb.reverse();
                st.pop(); // pop [
                int k = 0;
                int j = 0;
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    k += (st.pop() - '0') * Math.pow(10, j);
                    j++;
                }
                for (int i = 0; i < k; i++) {
                    for (j = 0; j < sb.length(); j++) {
                        st.push(sb.charAt(j));
                    }
                }

            } else {
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }

        return sb.toString();
    }
}