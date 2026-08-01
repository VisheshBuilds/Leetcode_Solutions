class Solution {
    public String simplifyPath(String s) {
        Stack<String> st=new Stack<>();
        int i=0,n=s.length();
        while(i<n){
            char ch=s.charAt(i);
            if(ch=='/'){
                while(i<n && s.charAt(i)=='/') i++;
                if(!st.isEmpty() && st.peek().equals("/")) continue;
                st.push("/");
            }
            else if(ch=='.'){
                StringBuilder sb=new StringBuilder();
                while(i<n && s.charAt(i)!='/'){
                    sb.append(s.charAt(i));
                    i++;
                }
                if(sb.toString().equals("..")){
                    st.pop();
                    if(!st.isEmpty()) st.pop();
                }
                else if(sb.toString().equals(".")) st.pop();
                else st.push(sb.toString());
            }
            else {
                StringBuilder sb=new StringBuilder();
                while(i<n && s.charAt(i)!='/'){
                    sb.append(s.charAt(i));
                    i++;
                }
                st.push(sb.toString());
            }
        }
        StringBuilder sb=new StringBuilder();
        boolean last=false;
        while(!st.isEmpty()){
            String k=st.pop();
            if(last==false && k.equals("/")) continue;
            last=true;
            if(!st.isEmpty() && k.equals("/") && st.peek().equals("/")) continue;
            sb.insert(0,k);
        }
        if(sb.length()==0) return "/";
        return sb.toString();
    }
}