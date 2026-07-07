class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(Character ch: s.toCharArray()){
            if(ch=='(')  st.push(ch);
            else if(ch==')'){
                if(st.isEmpty()) continue;
                else st.pop();
            }
            sb.append(ch);  
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
    
        return sb.toString();
    }
}