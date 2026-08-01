class MinStack {
    Stack<Integer> st;
    PriorityQueue<Integer> minheap;
    public MinStack() {
        st=new Stack<>();
        minheap=new PriorityQueue<>();
    }
    
    public void push(int value) {
        st.push(value);
        minheap.add(value);
    }
    
    public void pop() {
        int x=st.pop();
        minheap.remove(x);
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minheap.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */