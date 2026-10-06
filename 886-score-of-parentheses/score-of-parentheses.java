class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> st=new Stack<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') st.push("(");
            else{
                int sum=0;
                while(!st.peek().equals("(")){
                    sum +=Integer.valueOf(st.pop());
                }
                if(sum==0){
                    st.pop();
                    st.push("1");
                }
                else{
                    st.pop();
                    st.push(String.valueOf(2*sum));
                }
            }
        }
        int sum=0;
        while(!st.isEmpty()){
            sum +=Integer.valueOf(st.pop());
        }
        return sum;
    }
}