class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        st.push(s.charAt(0));
        int i=1,n=s.length();
        while(i<n){
            char ch=s.charAt(i);
            if(!st.isEmpty() && ch==')' && st.peek()=='(') st.pop();
            else if(!st.isEmpty() && ch==']' && st.peek()=='[') st.pop();
            else if(!st.isEmpty() && ch=='}' && st.peek()=='{') st.pop();
            else st.push(ch);
            i++;
        }
        return st.isEmpty();
    }
}