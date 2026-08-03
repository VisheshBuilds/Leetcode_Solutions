class Solution {
    public int evalRPN(String[] tokens) {
        int ans=0,n=tokens.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            String s=tokens[i];
            if(s.equals("+")){
               int a=st.pop();
               int b=st.pop();
               st.push(b+a);
            }
            else if(s.equals("-")){
               int a=st.pop();
               int b=st.pop();
               st.push(b-a);
            }
            else if(s.equals("*")){
               int a=st.pop();
               int b=st.pop();
               st.push(b*a);
            }
            else if(s.equals("/")){
               int a=st.pop();
               int b=st.pop();
               st.push(b/a);
            }
            else{
                st.push(Integer.valueOf(s));
            }
            
        }
        return st.peek();
    }
}