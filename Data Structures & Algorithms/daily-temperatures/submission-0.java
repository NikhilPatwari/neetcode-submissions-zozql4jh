class Solution {
    public int[] dailyTemperatures(int[] temps) {
        Stack<Pair> st = new Stack<>();
        int[] sol = new int[temps.length];
        for (int i = 0; i < temps.length; i++) {
            int temp = temps[i];
            while (!st.isEmpty() && st.peek().temp < temp) {
                Pair top = st.peek();
                st.pop();
                sol[top.index] = i - top.index;
            }
            st.push(new Pair(i, temp));
        }
        return sol;
    }
}
class Pair {
    public int index;
    public int temp;
    public Pair(int index, int temp) {
        this.index = index;
        this.temp = temp;
    }
}
