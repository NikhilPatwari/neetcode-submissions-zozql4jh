class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for (int l = 0; l < s.length(); l++) {
            char c = s.charAt(l);
            if (c == ']') {
                String temp = "";
                while (st.peek() != '[') {
                    temp = st.pop() + temp;
                }
                st.pop(); // pop [
                int k = 0;
                int j = 0;
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    k += (st.pop() - '0') * Math.pow(10, j);
                    j++;
                }
                for (int i = 0; i < k; i++) {
                    for (j = 0; j < temp.length(); j++) {
                        st.push(temp.charAt(j));
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