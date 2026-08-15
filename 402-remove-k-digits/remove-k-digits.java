class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        if(n==k) return "0";
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=num.charAt(i);
            while(!st.isEmpty() && st.peek()>ch && k!=0){
                 st.pop();
                 k--;
            }
            st.push(ch);
        }
        while(!st.isEmpty() && k!=0){
            st.pop();
            k--;
        }

        while(!st.isEmpty()) sb.append(st.pop());
        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)=='0') sb.deleteCharAt(i);
            else break;
        }
        if(sb.length()==0) return "0";
        sb.reverse();
         
        return sb.toString();
    }
}