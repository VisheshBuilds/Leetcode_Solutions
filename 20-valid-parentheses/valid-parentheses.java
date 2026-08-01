class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int i=0,n=s.length();
        while(i<n){
            char ch=s.charAt(i);
            if(ch=='{' || ch=='[' || ch=='(') st.push(ch);
            else if(ch=='}' && !st.isEmpty() && st.peek()=='{') st.pop();
            else if(ch==']' && !st.isEmpty() && st.peek()=='[') st.pop();
            else if(ch==')' && !st.isEmpty() && st.peek()=='(') st.pop();
            else return false;
            i++;
        }
        return st.isEmpty();
    }
}