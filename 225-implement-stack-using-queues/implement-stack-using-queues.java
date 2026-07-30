class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();

    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        if(q1.isEmpty()) return -1;

        while(q1.size()>1){
            q2.offer(q1.poll());
        }
        int last=q1.poll();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return last;
    }
    
    public int top() {
        if(q1.isEmpty()) return -1;
        int last=0;
        while(!q1.isEmpty()){
            last=q1.remove();
            q2.add(last);
        }
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
        return last;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */