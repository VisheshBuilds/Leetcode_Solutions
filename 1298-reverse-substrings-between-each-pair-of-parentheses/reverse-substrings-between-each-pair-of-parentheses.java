class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        int n=s.length();
        int[] idx=new int[n];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='(') st.push(i);
            else if(ch==')'){
                int j=st.pop();
                idx[i]=j;
                idx[j]=i;
            }
        }
        StringBuilder ans=new StringBuilder();
        int dir=1; // left to right
        for(int i=0;i<n;i +=dir){
            char ch=s.charAt(i);
            if(ch=='(' || ch==')'){
                i=idx[i];
                dir = -dir;
            }
            else{
                ans.append(ch);
            }
        }
        
        return ans.toString();
    }
}