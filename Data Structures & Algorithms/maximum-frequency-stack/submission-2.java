class FreqStack {
    List<Stack<Integer>> list;
    Map<Integer, Integer> map;

    public FreqStack() {
        list = new LinkedList<>();
        list.add(new Stack<>());
        map = new HashMap<>();
    }

    public void push(int val) {
        int freq = map.getOrDefault(val, 0) + 1;
        map.put(val, freq);
        if (freq == list.size()) {
            list.add(new Stack<>());
        }
        list.get(freq).push(val);
    }

    public int pop() {
        Stack<Integer> st = list.get(list.size() - 1);
        int res = st.pop();
        map.put(res, map.get(res) - 1);
        if (st.isEmpty()) {
            list.remove(list.size() - 1);
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */