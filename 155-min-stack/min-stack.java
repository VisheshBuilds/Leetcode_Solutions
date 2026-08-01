class MinStack {
    class Pair{
        int curr;
        int minm;
        Pair(int curr,int minm){
            this.curr=curr;
            this.minm=minm;
        }
    }
    Stack<Pair> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push(new Pair(value,value));
            return;
        } 
        Pair p=st.peek();
        int minimum=Math.min(p.minm,value);
        st.push(new Pair(value,minimum));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        Pair p=st.peek();
        return p.curr;
    }
    
    public int getMin() {
        Pair p=st.peek();
        return p.minm;
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