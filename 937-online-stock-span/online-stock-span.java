class StockSpanner {
    Stack<Pair> st;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        int count=0;

        while(!st.isEmpty() && st.peek().val <= price){
            count +=st.peek().freq;
            st.pop();
        }
        st.push(new Pair(price,count+1));
        return count+1;
    }

    public class Pair{
        int val;
        int freq;
        Pair(int val,int freq){
            this.val=val;
            this.freq=freq;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */