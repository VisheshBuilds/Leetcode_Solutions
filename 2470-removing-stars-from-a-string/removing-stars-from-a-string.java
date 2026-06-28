class Solution {
    public String removeStars(String s) {
        Stack<Character> st=new Stack<>();
        int i=0,n=s.length();
        
        while(i<n){
            char ch=s.charAt(i);
            if(ch=='*'){
                if(!st.isEmpty()) st.pop();
            }
            else st.push(ch); 
            i++;
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()) sb.append(st.pop());

        return sb.reverse().toString();
    }
}