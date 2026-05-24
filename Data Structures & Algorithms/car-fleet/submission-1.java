class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int sol = 0;
        Pair[] sortByPos = new Pair[position.length];
        for (int i = 0; i < position.length; i++) {
            sortByPos[i] = new Pair(time(target, position[i], speed[i]), position[i]);
        }
        Arrays.sort(sortByPos);
        Stack<Pair> st = new Stack<>();
        for (int i = sortByPos.length - 1; i >= 0; i--) {
            Pair curr = sortByPos[i];
            if (st.isEmpty()) {
                st.push(curr);
            } else {
                Pair top = st.peek();
                if (curr.time <= top.time) {
                    curr.time = top.time;
                    st.push(curr);
                } else {
                    sol++;
                    st.clear();
                    st.push(curr);
                }
            }
        }
        if (!st.isEmpty()) {
            sol++;
        }
        return sol;
    }
    public double time(int target, int pos, int speed) {
        int dist = target - pos;
        return (dist * 1.0) / (speed * 1.0);
    }
}
class Pair implements Comparable<Pair> {
    public double time;
    public int pos;
    public Pair(double time, int pos) {
        this.time = time;
        this.pos = pos;
    }
    @Override
    public int compareTo(Pair p2) {
        return this.pos - p2.pos;
    }
    @Override
    public String toString() {
        return "Pair:- pos : "+pos+" time : "+time;
    }
}