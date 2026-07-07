class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(Character ch: s.toCharArray()){
            if(ch=='('){
                st.push(ch);
                sb.append(ch);
            }
            else if(ch==')'){
                if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
                    sb.append(ch);
                }
            }
            else {
                sb.append(ch);
            }
        }
        if(!st.isEmpty()){
        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)=='('){
                sb.deleteCharAt(i);
                st.pop();
            }
            if(st.isEmpty()) break;
        }
        }
        // int i=0;
        // while(!st.isEmpty()){
             
        // }

        return sb.toString();
    }
}