class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int s2 = Integer.valueOf(st.pop());
                int s1 = Integer.valueOf(st.pop());
                switch (s) { 
                    case "+":
                        st.push(s1 + s2);
                        break;
                    case "-" : 
                        st.push(s1 - s2);
                        break;
                    case "*" : 
                        st.push(s1 * s2);
                        break;
                    case "/" : 
                        st.push(s1 / s2);
                }
            }else{
                st.push(Integer.valueOf(s));
            }
        }
        return st.pop();
    }
}