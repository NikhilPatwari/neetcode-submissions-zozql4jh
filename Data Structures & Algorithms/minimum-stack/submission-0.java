class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSoFar;

    public MinStack() {
        st = new Stack<Integer>();
        minSoFar = new Stack<Integer>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSoFar.isEmpty()){
            minSoFar.push(val);
        }else{
            if(minSoFar.peek() >= val){
                minSoFar.push(val);
            }else{
                minSoFar.push(minSoFar.peek());
            }
        }
    }
    
    public void pop() {
        st.pop();
        minSoFar.pop();
        
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSoFar.peek();
    }
}
